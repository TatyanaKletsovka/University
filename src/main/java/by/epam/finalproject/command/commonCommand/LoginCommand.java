package by.epam.finalproject.command.commonCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.resource.MessageManager;
import by.epam.finalproject.service.UserService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.finalproject.command.CommandConstant.*;

public class LoginCommand implements ActionCommand {

    private final static Logger LOGGER = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws Exception{

        HttpSession currentSession = request.getSession();

        String login = request.getParameter(LOGIN_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);

        UserService userService = new UserService();
        User user = userService.checkLoginAndPassword(login, password);

        if (user == null) {
            LOGGER.warn("User was not authorised.");
            request.setAttribute(ERROR_LOGIN_PASS_MESSAGE_ATTRIBUTE,
                    MessageManager.getProperty(ERROR_LOGIN_PASS_MESSAGE_PROPERTY));
            return LOGIN_JSP;
        }
        LOGGER.info("User " + user.getLogin() + " was authorised.");

        currentSession.setAttribute(USER_ATTRIBUTE, user);
        currentSession.setAttribute("isRedirect", false);

        return MAIN_JSP;
    }
}