package by.epam.finalproject.command;

import by.epam.finalproject.logic.LoginLogic;
import by.epam.finalproject.path.Page;
import by.epam.finalproject.resource.ConfigurationManager;
import by.epam.finalproject.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        // проверка логина и пароля
        if (LoginLogic.checkLogin(login, pass)) {
            request.setAttribute("user", login);
        // определение пути к main.jsp
            page = //Page.MAIN;
            ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage", //"Incorrect login or password.");
                    MessageManager.getProperty("message.loginerror"));
            page = //Page.LOGIN;
            ConfigurationManager.getProperty("path.page.index");
        }
        return page;
    }
}
