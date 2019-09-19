package by.epam.finalproject.command;

import by.epam.finalproject.entity.User;
import by.epam.finalproject.resource.ConfigurationManager;
import by.epam.finalproject.resource.MessageManager;
import by.epam.finalproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {

        try {
            // извлечение из запроса логина и пароля
            String login = request.getParameter(PARAM_NAME_LOGIN);
            String password = request.getParameter(PARAM_NAME_PASSWORD);

            // проверка логина и пароля
            UserService userService = new UserService();
            User user = userService.login(login, password);
            if (user != null) {
                request.getSession().setAttribute("loggedInUser", user);
            }
            if (user == null) {
                request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.login_error"));
                request.getSession().setAttribute("loggedInUser", null);
                return new String("/index.jsp");
            }

            HttpSession currentSession = request.getSession();
            if (currentSession == null || currentSession.getAttribute("loggedInUser") == null) {
                // user is not logged in, do something about it
            } else {
                // user IS logged in, do something: set model or do whatever you need
            }
            currentSession.setAttribute("user", user);

            return new String("/jsp/main.jsp");
        } catch (Exception e) {
            return new String("/jsp/error/error.jsp");
        }
/*
        String page = null;


        if (user != null) {
            request.setAttribute("user", login);
            request.setAttribute("role", password);
            // определение пути к main.jsp
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.login_error"));
            page = ConfigurationManager.getProperty("path.page.index");
        }
        return page;*/
    }
}
