package by.epam.finalproject.command.adminCommand;

import by.epam.finalproject.command.AbstractCommand;
import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.finalproject.command.CommandConstant.SHOW_ALL_USERS_ADMIN_JSP;
import static by.epam.finalproject.command.CommandConstant.SHOW_ALL_USERS_ATTRIBUTE;

public class ShowAllUsersCommand extends AbstractCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws ServiceException {

        UserService userService = new UserService(proxyConnection.getConnection());
        List<User> showAllUsers = userService.findAll();

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute(SHOW_ALL_USERS_ATTRIBUTE, showAllUsers);

        return SHOW_ALL_USERS_ADMIN_JSP;
    }
}
