package by.epam.finalproject.command.adminCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.finalproject.command.CommandConstant.SHOW_ALL_USERS_ADMIN_JSP;
import static by.epam.finalproject.command.CommandConstant.SHOW_ALL_USERS_ATTRIBUTE;

public class ShowAllUsers implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws DaoException {

        UserService userService = new UserService();
        List<User> showAllUsers = userService.findAll();

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute(SHOW_ALL_USERS_ATTRIBUTE, showAllUsers);

        return SHOW_ALL_USERS_ADMIN_JSP;
    }
}
