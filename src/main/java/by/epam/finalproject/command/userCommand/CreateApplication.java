package by.epam.finalproject.command.userCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.entity.*;
import by.epam.finalproject.service.ApplicationService;
import by.epam.finalproject.service.FacultyService;
import by.epam.finalproject.service.MarkService;
import by.epam.finalproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CreateApplication implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        try {
            String facultyId = request.getParameter("facultyId");

            FacultyService facultyService = new FacultyService();
            Faculty faculty = facultyService.findFaculty(facultyId);

            List<Mark> marks = new ArrayList<>();
            for (int i = 0; i < faculty.getSubjects().size(); i++) {
                Subject subject = faculty.getSubjects().get(i);
                String subjectId = String.valueOf(subject.getId());
                String subjectMarkValue = request.getParameter(subjectId);
                Mark mark = new Mark(subject, Integer.parseInt(subjectMarkValue));
                marks.add(mark);
            }
            String certificate = request.getParameter("Certificate");

            HttpSession currentSession = request.getSession();
            User user = (User) currentSession.getAttribute("user");

/*            HttpSession currentSession = request.getSession();
            Student student = (Student) currentSession.getAttribute("user");
            student.setCertificate(Integer.parseInt(certificate));
            student.setMarks(marks);
            currentSession.setAttribute("student", student);*/

            UserService userService = new UserService();
            String userId = String.valueOf(user.getId());  //student

            boolean isUpdateCertificate = userService.isUpdateCertificate(certificate, userId);

            MarkService markService = new MarkService();
            for (int i = 0; i < marks.size(); i++) {
                markService.isUpdate(userId, String.valueOf(marks.get(i).getSubject().getId()),
                        String.valueOf(marks.get(i).getValue()));
            }

            ApplicationService applicationService = new ApplicationService();
            boolean isUpdateApplication = applicationService.createApplication(facultyId, userId);

            currentSession.setAttribute("isRedirect", true);

            if (isUpdateCertificate && isUpdateApplication) {
                return "/jsp/common/main.jsp";
            } else {
                return "/jsp/general/showAllFaculties.jsp";
            }


        } catch (Exception exception) {
            //        LOGGER.error(exception.getMessage(), exception);
            return "/jsp/error/error.jsp";
        }
    }
}
