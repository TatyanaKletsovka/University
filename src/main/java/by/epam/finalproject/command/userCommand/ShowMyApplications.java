package by.epam.finalproject.command.userCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowMyApplications implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        try {

            HttpSession currentSession = request.getSession();
            User user = (User) currentSession.getAttribute("user");
            String login = user.getLogin();

            ApplicationService applicationService = new ApplicationService();
            List<Application> showMyApplications = applicationService.findAllWhereUserLogin(login);

            currentSession.setAttribute("showMyApplications", showMyApplications);
            return "/jsp/user/showMyApplications.jsp";
        } catch (Exception e) {
            return "/jsp/error/error.jsp";
        }
    }
}
