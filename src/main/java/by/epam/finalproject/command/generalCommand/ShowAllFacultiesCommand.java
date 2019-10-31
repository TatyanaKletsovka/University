package by.epam.finalproject.command.generalCommand;

import by.epam.finalproject.command.AbstractCommand;
import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.service.FacultyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.epam.finalproject.command.CommandConstant.SHOW_ALL_FACULTIES_ATTRIBUTE;
import static by.epam.finalproject.command.CommandConstant.SHOW_ALL_FACULTIES_GENERAL_JSP;

public class ShowAllFacultiesCommand extends AbstractCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws ServiceException {

        FacultyService facultyService = new FacultyService(proxyConnection.getConnection());
        List<Faculty> showAllFaculties = facultyService.findAll();

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute(SHOW_ALL_FACULTIES_ATTRIBUTE, showAllFaculties);

        return SHOW_ALL_FACULTIES_GENERAL_JSP;
    }
}
