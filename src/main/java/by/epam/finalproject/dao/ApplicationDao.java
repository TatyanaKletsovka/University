package by.epam.finalproject.dao;

import by.epam.finalproject.builder.ApplicationBuilder;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.exception.DaoException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDao extends AbstractDao<String, Application> {

    private final static Logger LOGGER = Logger.getLogger(ApplicationDao.class);

    private static final String INSERT_INTO_APPLICATION =
            "INSERT INTO application (faculty_id, user_id) values (?, ?)";
    private static final String SELECT_ALL_APPLICATIONS_JOIN_FACULTY_USER_MARK =
            "SELECT application.id, faculty.id, faculty.name, places, passing_points, user.login, user.firstName, user.lastName, " +
            "user.certificate, subject.name, mark.value, status, date_of_register FROM application " +
            "JOIN faculty ON application.faculty_id = faculty.id " +
            "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
            "JOIN subject ON subjects_in_faculty.subject_id = subject.id " +
            "JOIN user ON application.user_id = user.id " +
            "JOIN mark ON mark.user_id = user.id " +
            "AND mark.subject_id = subject.id ";
    private static final String SELECT_ALL_APPLICATIONS_JOIN_FACULTY_USER_MARK_WHERE_USER_LOGIN =
            "SELECT application.id, faculty.id, faculty.name, places, passing_points, user.login, user.firstName, user.lastName, " +
            "user.certificate, subject.name, mark.value, status, date_of_register FROM application " +
            "JOIN faculty ON application.faculty_id = faculty.id " +
            "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
            "JOIN subject ON subjects_in_faculty.subject_id = subject.id " +
            "JOIN user ON application.user_id = user.id " +
            "JOIN mark ON mark.user_id = user.id " +
            "AND mark.subject_id = subject.id " +
            "where user.login = ?";
    private static final String SELECT_ALL_APPLICATIONS_JOIN_FACULTY_USER_MARK_WHERE_FACULTY_ID =
            "SELECT application.id, faculty.id, faculty.name, places, passing_points, user.login, user.firstName, user.lastName, " +
                    "user.certificate, subject.name, mark.value, status, date_of_register FROM application " +
                    "JOIN faculty ON application.faculty_id = faculty.id " +
                    "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
                    "JOIN subject ON subjects_in_faculty.subject_id = subject.id " +
                    "JOIN user ON application.user_id = user.id " +
                    "JOIN mark ON mark.user_id = user.id " +
                    "AND mark.subject_id = subject.id " +
                    "where faculty.id = ?";
    private static final String DELETE_APPLICATION_WHERE_ID =
            "DELETE FROM application where application.id = ?";

    private static final String UPDATE_APPLICATION_SET_STATUS_WHERE_ID =
            "UPDATE application SET status = ? WHERE application.id = ?";

    public ApplicationDao(Connection connection) {
        super(connection);
    }

    public boolean createApplication(String facultyId, String userId) throws DaoException {

        return executeUpdate(INSERT_INTO_APPLICATION, facultyId, userId);
    }

    @Override
    public List<Application> findAll() throws DaoException {

        List<Application> allApplications = executeQuery(SELECT_ALL_APPLICATIONS_JOIN_FACULTY_USER_MARK,
                new ApplicationBuilder());
        if (allApplications != null) {
            List<Application> currentApplications = createListCurrentApplications(allApplications);
            return currentApplications;
        }
        return null;
    }

    public List<Application> findAllWhereUserLogin(String login) throws DaoException {

        List<Application> allApplications = executeQuery(SELECT_ALL_APPLICATIONS_JOIN_FACULTY_USER_MARK_WHERE_USER_LOGIN,
                new ApplicationBuilder(), login);
        return createListCurrentApplications(allApplications);
    }

    public List<Application> findAllWhereFacultyId(String facultyId) throws DaoException {

        List<Application> allApplications = executeQuery(SELECT_ALL_APPLICATIONS_JOIN_FACULTY_USER_MARK_WHERE_FACULTY_ID,
                new ApplicationBuilder(), facultyId);
        return createListCurrentApplications(allApplications);
    }

    public void updateApplicationStatus(String status, String applicationId) throws DaoException {

        executeUpdate(UPDATE_APPLICATION_SET_STATUS_WHERE_ID, status, applicationId);
        LOGGER.info("Application: " + applicationId + " is updated");

    }

    @Override
    public Application findById(String id) throws DaoException {
        return null;
    }

    public boolean delete(String applicationId) throws DaoException {

        return executeUpdate(DELETE_APPLICATION_WHERE_ID, applicationId);
    }

    private List<Application> createListCurrentApplications(List<Application> allApplications) {

        List<Application> currentApplications = new ArrayList<>();
        for (int i = 0; i < allApplications.size();) {
            Application application = allApplications.get(i);
            int id = application.getId();
            i++;
            while (i < allApplications.size() && id == allApplications.get(i).getId()) {
                application.getStudent().addMark(allApplications.get(i).getStudent().getMarks().get(0));
                i++;
            }
            currentApplications.add(application);
        }
        return currentApplications;
    }
}
