package by.epam.finalproject.command.commonCommand;

import by.epam.finalproject.command.AbstractCommand;
import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.resource.MessageManager;
import by.epam.finalproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.finalproject.command.CommandConstant.*;

public class LoginCommand extends AbstractCommand implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) throws ServiceException {

        String login = request.getParameter(LOGIN_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);

        UserService userService = new UserService(proxyConnection.getConnection());
        User user = userService.checkLoginAndPassword(login, password);

        if (user == null) {
            request.setAttribute(ERROR_LOGIN_MESSAGE_ATTRIBUTE, MessageManager.getProperty(ERROR_LOGIN_MESSAGE_PROPERTY));
            return LOGIN_JSP;
        }

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute(USER_ATTRIBUTE, user);

        return MAIN_JSP;
    }
}
