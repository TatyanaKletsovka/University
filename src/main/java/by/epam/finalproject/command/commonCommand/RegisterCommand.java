package by.epam.finalproject.command.commonCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.resource.MessageManager;
import by.epam.finalproject.service.UserService;
import by.epam.finalproject.utils.RegisterValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RegisterCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(RegisterCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws DaoException{


        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");

        UserService userService = new UserService();
        boolean isLoginUnique = userService.checkUserLoginForUnique(login);
        if (!isLoginUnique) {
            request.setAttribute("errorUniqueLoginMessage",
                    MessageManager.getProperty("message.not_unique_login_error"));
            return "/jsp/common/register.jsp";
        }

        RegisterValidator validator = new RegisterValidator();
        boolean isUserValid = validator.checkData(login, password, firstName, lastName);
        if (!isUserValid) {
            return "/jsp/common/register.jsp";
        }

        User user = userService.register(login, password, firstName, lastName);
        if (user != null) {
        }else {
            return "/index.jsp";
        }
//           if (!isOperationSuccessful) {
//             return new Page(Page.REGISTER_PAGE_PATH, false, REGISTRATION_FAILED_MESSAGE_KEY);
//           }

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute("user", user);

        return "/jsp/common/main.jsp";


    }
}