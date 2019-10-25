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

import static by.epam.finalproject.command.CommandConstant.ERROR_JSP;
import static by.epam.finalproject.command.CommandConstant.IS_REDIRECT_ATTRIBUTE;

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

        ActionFactory actionFactory = new ActionFactory();
        ActionCommand command = actionFactory.defineCommand(request);
        LOGGER.debug("Command = " + command);

        try {
            page = command.execute(request);
            if (request.getAttribute(IS_REDIRECT_ATTRIBUTE) != null) {
                redirect(page, request, response);
            } else {
                forward(page, request, response);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            forward(ERROR_JSP, request, response);
        }
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
