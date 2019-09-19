package by.epam.finalproject.controller;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.command.factory.ActionFactory;
import by.epam.finalproject.resource.ConfigurationManager;
import by.epam.finalproject.resource.MessageManager;

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

    private static final long TIME = 3600;

    HttpSession session;

    @Override
    public void init() throws ServletException {
/*        try {
            ConnectionPool.getInstance();
            GameWarehouse.getInstance();
            ConnectionTimer timer = ConnectionTimer.getInstance();
            TimerTask timerTask = new ConnectionTimerTask();
            timer.schedule(timerTask, TIME, TIME);
        } catch (ConnectionException e) {
            logger.fatal("Servlet can't begin work due to a internal error", e);
        } catch (IncorrectDataException e) {
            logger.warn("Timer doesn't begin checking connections", e);
        }*/
    }

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

/*        session = request.getSession();
        if(session.isNew()) {
            session.setAttribute("isAdmin", false);
        }*/

        // определение команды, пришедшей из JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        /*
         * вызов реализованного метода execute() и передача параметров
         * классу-обработчику конкретной команды
         */
        page = command.execute(request);
        // метод возвращает страницу ответа
        // page = null; // поэксперементировать!
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            // установка страницы c сообщением об ошибке
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage", MessageManager.getProperty(("message.null_page")));
            response.sendRedirect(request.getContextPath() + page);
        }
    }

    @Override
    public void destroy() {
        session.invalidate();
    }
}
