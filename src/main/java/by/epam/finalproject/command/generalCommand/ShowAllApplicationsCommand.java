package by.epam.finalproject.command.generalCommand;

import by.epam.finalproject.command.AbstractCommand;
import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.finalproject.command.CommandConstant.SHOW_ALL_APPLICATIONS_ATTRIBUTE;
import static by.epam.finalproject.command.CommandConstant.SHOW_ALL_APPLICATIONS_GENERAL_JSP;

public class ShowAllApplicationsCommand extends AbstractCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws ServiceException {

        ApplicationService applicationService = new ApplicationService(proxyConnection.getConnection());
        List<Application> showAllApplications = applicationService.findAll();

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute(SHOW_ALL_APPLICATIONS_ATTRIBUTE, showAllApplications);

        return SHOW_ALL_APPLICATIONS_GENERAL_JSP;
    }
}
