package by.epam.finalproject.command.userCommand;

import by.epam.finalproject.command.AbstractCommand;
import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.finalproject.command.CommandConstant.*;

public class ShowMyApplications extends AbstractCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws DaoException {

        HttpSession currentSession = request.getSession();
        User user = (User) currentSession.getAttribute(USER_ATTRIBUTE);
        String login = user.getLogin();

        ApplicationService applicationService = new ApplicationService(proxyConnection.getConnection());
        List<Application> showMyApplications = applicationService.findAllWhereUserLogin(login);

        currentSession.setAttribute(SHOW_MY_APPLICATIONS_ATTRIBUTE, showMyApplications);
        return SHOW_MY_APPLICATIONS_USER_JSP;
    }
}
