package by.epam.finalproject.command.generalCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowAllApplications implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        try {

            ApplicationService applicationService = new ApplicationService();

            List<Application> showAllApplications = applicationService.findAll();

            HttpSession currentSession = request.getSession();

            currentSession.setAttribute("showAllApplications", showAllApplications);
            return "/jsp/general/showAllApplications.jsp";
        } catch (Exception e) {
            return "/jsp/error/error.jsp";
        }
    }
}
