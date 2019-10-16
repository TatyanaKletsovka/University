package by.epam.finalproject.command.userCommand;

import by.epam.finalproject.command.AbstractCommand;
import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.service.FacultyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.finalproject.command.CommandConstant.*;

public class GoToApplicationPage extends AbstractCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws DaoException {

        String facultyId = request.getParameter(FACULTY_ID_PARAMETER);

        FacultyService facultyService = new FacultyService(proxyConnection.getConnection());
        Faculty faculty = facultyService.findFaculty(facultyId);

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute(FACULTY_ATTRIBUTE, faculty);
        currentSession.removeAttribute(APPLICATION_CREATED_ATTRIBUTE);

        return CREATE_APPLICATION_USER_JSP;
    }
}
