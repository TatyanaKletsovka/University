package by.epam.finalproject.command.adminCommand;

import by.epam.finalproject.command.AbstractCommand;
import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.command.generalCommand.ShowAllApplicationsCommand;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.entity.Status;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.service.ApplicationService;
import by.epam.finalproject.service.FacultyService;
import by.epam.finalproject.utils.comparator.SumComparator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ProcessApplicationsCommand extends AbstractCommand implements ActionCommand {

    private final static Logger LOGGER = Logger.getLogger(ProcessApplicationsCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws DaoException {

        FacultyService facultyService = new FacultyService(proxyConnection.getConnection());
        List<Faculty> faculties = facultyService.findAll();
        LOGGER.info("List faculties created.");

        ApplicationService applicationService = new ApplicationService(proxyConnection.getConnection());
        List<Application> applicationsToUpdateStatus = new ArrayList<>();

        for (int i = 0; i < faculties.size(); i++) {
            Faculty faculty = faculties.get(i);
            List<Application> applications = applicationService.findAllWhereFacultyId(String.valueOf(faculty.getId()));
            applications.sort(new SumComparator());
            LOGGER.info("Faculty: " + faculty.getName() + " in process");

            for (int j = 0; j < applications.size(); j++) {
                Application application = applications.get(j);
                if (j < faculty.getPlaces()) {
                    application.setStatus(Status.ACCEPTED);
                } else {
                    application.setStatus(Status.REJECTED);
                }
                applicationsToUpdateStatus.add(application);
                LOGGER.info("Application: " + application.getId() + " in process");

            }
        }

        applicationService.updateApplicationStatus(applicationsToUpdateStatus);

        ShowAllApplicationsCommand showAllApplicationsCommand = new ShowAllApplicationsCommand();
        return showAllApplicationsCommand.execute(request);
    }
}
