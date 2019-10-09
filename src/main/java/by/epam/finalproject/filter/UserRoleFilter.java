package by.epam.finalproject.filter;

import by.epam.finalproject.entity.ROLE;
import by.epam.finalproject.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@WebFilter(urlPatterns = { "/controller" }, servletNames = { "Controller" })
public class UserRoleFilter implements Filter {



    private static final String MAIN_PAGE_PARAMETER = "MAIN_PAGE";



    private String redirectPage;
    private List<String> userCommands;
    private List<String> adminCommands;

    /**
     * This method initialize filters object.
     *
     * @param filterConfig the filters config.
     * @throws ServletException object if execution of method is failed.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        redirectPage = filterConfig.getInitParameter(MAIN_PAGE_PARAMETER);
        userCommands = new ArrayList<>
                (Arrays.asList("login", "logout", "common_register",
                "show_all_applications", "show_all_faculties",
                "go_to_application_page", "create_application", "show_my_applications", "delete_application"));
        adminCommands = new ArrayList<>
                (Arrays.asList("login", "logout", "common_register",
                        "show_all_applications", "show_all_faculties",
                        "show_all_users"));
    }

    /**
     * The method does main logic of filters.
     *
     * @param request           the servlet request.
     * @param response          the servlet response.
     * @param filterChain       the filters chain of responsibility.
     * @throws IOException      object if execution of method is failed.
     * @throws ServletException object if execution of method is failed.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String command = request.getParameter("command");
        //if common page - continue
        if(command == null) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = httpServletRequest.getSession();
            User user = (User) session.getAttribute("user");
            if (command.equals("login") || command.equals("common_register") || command.equals("common_change_language")) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            } else {
                if (user == null) {
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/jsp/error/error.jsp");
                } else {
                    ROLE role = user.getRole();
                    List<String> accessCommands = getListAccessCommands(role);
                    if (accessCommands == null) {
                        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/jsp/error/error.jsp");
                    }
                    boolean userHasAccess = checkAccess(accessCommands, command);
                    if (userHasAccess) {
                        filterChain.doFilter(httpServletRequest, httpServletResponse);
                    } else {
                        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/jsp/error/error.jsp");
                    }
                }
            }
        }


    }

    @Override
    public void destroy() {

    }

    private List<String> getListAccessCommands(ROLE userRole) {
        List<String> accessCommands = null;
        switch (userRole) {
            case USER: {
                accessCommands = userCommands;
                break;
            }
            case ADMIN: {
                accessCommands = adminCommands;
                break;
            }
        }
        return accessCommands;
    }

    private boolean checkAccess(List<String> accessCommands, String parameter) {

        for (int i = 0; i < accessCommands.size(); i++) {
            if (accessCommands.get(i).equals(parameter)) {
                return true;
            }
        }
        return false;
    }

}
