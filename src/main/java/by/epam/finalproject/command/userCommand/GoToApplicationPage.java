package by.epam.finalproject.command.userCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.service.FacultyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoToApplicationPage implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        try {

            String facultyId = request.getParameter("facultyId");
            FacultyService facultyService = new FacultyService();
            Faculty faculty = facultyService.findFaculty(facultyId);


            HttpSession currentSession = request.getSession();

            currentSession.setAttribute("faculty", faculty);
            return "/jsp/user/createApplication.jsp";
        } catch (Exception e) {
            return "/jsp/error/error.jsp";
        }
    }
}
