package by.epam.finalproject.command.adminCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.service.FacultyService;
import by.epam.finalproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowAllUsers implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        try {

            UserService userService = new UserService();
        //    Map<Integer, User> users = userService.findAll();   //(currentOffSet, MAX_RECORDS_PER_PAGE_COUNT);
            //   Set<Map.Entry<List<User>, Integer>> entries = clients.entrySet();

            List<User> showAllUsers = userService.findAll();


            //      int numberOfPages = (int) Math.ceil(numberOfRecords * 1.0 / MAX_RECORDS_PER_PAGE_COUNT);

            HttpSession currentSession = request.getSession();

            currentSession.setAttribute("showAllUsers", showAllUsers);
            return "/jsp/admin/showAllUsers.jsp";
        } catch (Exception e) {
            return "/jsp/error/error.jsp";
        }
    }
}
