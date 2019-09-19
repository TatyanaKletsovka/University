package by.epam.finalproject.command;

import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.resource.MessageManager;
import by.epam.finalproject.service.FacultyService;
import by.epam.finalproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShowAllFaculties implements ActionCommand {

    private static final int MAX_RECORDS_PER_PAGE_COUNT = 10;
    private static final int FIRST_PAGE_INDEX = 1;

    @Override
    public String execute(HttpServletRequest request) {

        try {
/*            int pageIndex = FIRST_PAGE_INDEX;

            String pageParameterValue = request.getParameter("page");

            if (pageParameterValue != null) {
                pageIndex = Integer.parseInt(pageParameterValue);
            }
            int currentOffSet = (pageIndex - 1) * MAX_RECORDS_PER_PAGE_COUNT;*/

            FacultyService facultyService = new FacultyService();
            Map<Integer, Faculty> faculties = facultyService.findAll();   //(currentOffSet, MAX_RECORDS_PER_PAGE_COUNT);
         //   Set<Map.Entry<List<User>, Integer>> entries = clients.entrySet();

            List<Faculty> showAllFaculties = new ArrayList<>(faculties.values());


      //      int numberOfPages = (int) Math.ceil(numberOfRecords * 1.0 / MAX_RECORDS_PER_PAGE_COUNT);

            HttpSession currentSession = request.getSession();

            currentSession.setAttribute("showAllFaculties", showAllFaculties);
            return new String("/jsp/show_all_faculties.jsp");
        } catch (Exception e) {
            return new String("/jsp/error/error.jsp");
        }
    }
}
