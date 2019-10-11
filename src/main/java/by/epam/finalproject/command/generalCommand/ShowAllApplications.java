package by.epam.finalproject.command.generalCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.finalproject.command.CommandConstant.SHOW_ALL_APPLICATIONS_ATTRIBUTE;
import static by.epam.finalproject.command.CommandConstant.SHOW_ALL_APPLICATIONS_GENERAL_JSP;

public class ShowAllApplications implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws DaoException {

        ApplicationService applicationService = new ApplicationService();
        List<Application> showAllApplications = applicationService.findAll();

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute(SHOW_ALL_APPLICATIONS_ATTRIBUTE, showAllApplications);

        return SHOW_ALL_APPLICATIONS_GENERAL_JSP;
    }
}
