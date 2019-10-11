package by.epam.finalproject.controller;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.command.factory.ActionFactory;
import by.epam.finalproject.resource.ConfigurationManager;
import by.epam.finalproject.resource.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/by/epam/finalproject/controller")
public class Controller extends HttpServlet {

    HttpSession session;
    private final static Logger LOGGER = Logger.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page;

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        LOGGER.info("Command = " + command);

        Boolean isRedirect = (Boolean) request.getAttribute("isRedirect");

        try {
            page = command.execute(request);
            if (isRedirect) {
                redirect(page, request, response);
            } else {
                forward(page, request, response);
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", MessageManager.getProperty("message.wrong_action"));
            forward("/jsp/error/error.jsp", request, response);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            forward("/jsp/error/error.jsp", request, response);
        }
        // метод возвращает страницу ответа




/*        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            // установка страницы c сообщением об ошибке
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage", MessageManager.getProperty(("message.null_page")));
            response.sendRedirect(request.getContextPath() + page);
        }*/
    }

    private void redirect(String page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + page);
    }

    private void forward(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = MessageManager.getProperty("Page not found.");
        request.setAttribute("message", message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        session.invalidate();
    }
}
