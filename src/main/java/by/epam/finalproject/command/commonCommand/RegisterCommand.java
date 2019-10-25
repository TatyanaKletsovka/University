package by.epam.finalproject.command.commonCommand;

import by.epam.finalproject.command.AbstractCommand;
import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.resource.MessageManager;
import by.epam.finalproject.service.UserService;
import by.epam.finalproject.utils.RegisterValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.finalproject.command.CommandConstant.*;

public class RegisterCommand extends AbstractCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(RegisterCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws DaoException{


        String login = request.getParameter(LOGIN_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);
        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);

        UserService userService = new UserService(proxyConnection.getConnection());
        boolean isLoginUnique = userService.checkUserLoginForUnique(login);
        if (!isLoginUnique) {
            LOGGER.warn("LoginCommand was not unique.");
            request.setAttribute(ERROR_UNIQUE_LOGIN_MESSAGE_ATTRIBUTE,
                    MessageManager.getProperty(ERROR_UNIQUE_LOGIN_MESSAGE_PROPERTY));
            return REGISTER_JSP;
        }

        RegisterValidator validator = new RegisterValidator();
        boolean isUserValid = validator.checkData(login, password, firstName, lastName);
        if (!isUserValid) {
            LOGGER.warn("User data is not valid.");
            return REGISTER_JSP;
        }

        User user = userService.register(login, password, firstName, lastName);
        if (user == null) {
            return REGISTER_JSP;
        }

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute(USER_ATTRIBUTE, user);

        return MAIN_JSP;

    }
}