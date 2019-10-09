package by.epam.finalproject.dao;

import by.epam.finalproject.builder.ApplicationBuilder;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.exception.DaoException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDao extends AbstractDao<Integer, Application> {

    private static final String INSERT_INTO_APPLICATION =
            "INSERT INTO application (faculty_id, user_id) values (?, ?)";
    private static final String SELECT_ALL_APPLICATIONS_JOIN_FACULTY_USER_MARK =
            "SELECT application.id, faculty.name, places, passing_points, user.login, user.firstName, user.lastName, " +
            "user.certificate, subject.name, mark.value, status, date_of_register FROM application " +
            "JOIN faculty ON application.faculty_id = faculty.id " +
            "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
            "JOIN subject ON subjects_in_faculty.subject_id = subject.id " +
            "JOIN user ON application.user_id = user.id " +
            "JOIN mark ON mark.user_id = user.id " +
            "AND mark.subject_id = subject.id ";
    private static final String SELECT_ALL_APPLICATIONS_JOIN_FACULTY_USER_MARK_WHERE_USER_LOGIN =
            "SELECT application.id, faculty.name, places, passing_points, user.login, user.firstName, user.lastName, " +
            "user.certificate, subject.name, mark.value, status, date_of_register FROM application " +
            "JOIN faculty ON application.faculty_id = faculty.id " +
            "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
            "JOIN subject ON subjects_in_faculty.subject_id = subject.id " +
            "JOIN user ON application.user_id = user.id " +
            "JOIN mark ON mark.user_id = user.id " +
            "AND mark.subject_id = subject.id " +
            "where user.login = ?";
    private static final String DELETE_APPLICATION_WHERE_ID =
            "DELETE FROM application where id = ?";

    public boolean createApplication(String facultyId, String userId) throws DaoException {
        try {
            boolean isCreate = executeUpdate(INSERT_INTO_APPLICATION, facultyId, userId);
            return isCreate;
/*            if (isCreate) {
                List<Application> applications = executeQuery(SELECT_APPLICATION_BY_LOGIN, new UserBuilder(), login);
                return applications.get(0);
            }*/

        } catch (DaoException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Application> findAll() {
        try {
            List<Application> allApplications = executeQuery(SELECT_ALL_APPLICATIONS_JOIN_FACULTY_USER_MARK,
                    new ApplicationBuilder());
            List<Application> currentApplications = createListCurrentApplications(allApplications);
            return currentApplications;
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Application> findAllWhereUserLogin(String login) {
        try {
            List<Application> allApplications = executeQuery(SELECT_ALL_APPLICATIONS_JOIN_FACULTY_USER_MARK_WHERE_USER_LOGIN,
                    new ApplicationBuilder(), login);
            List<Application> currentApplications = createListCurrentApplications(allApplications);
            return currentApplications;
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Application entity) {
        return false;
    }

    @Override
    public boolean create(Application entity) {
        return false;
    }

    @Override
    public Application update(Application entity) {
        return null;
    }

    @Override
    protected Application buildEntity(ResultSet resultSet) throws DaoException {
        return null;
    }

    private List<Application> createListCurrentApplications(List<Application> allApplications) {
        List<Application> currentApplications = new ArrayList<>();
        for (int i = 0; i < allApplications.size();) {
            Application application = allApplications.get(i);
        //    int facultyId = application.getFaculty().getId();
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

    public boolean deleteApplicationWhereId(String applicationId) {
        try {
            boolean isDelete = executeUpdate(DELETE_APPLICATION_WHERE_ID, applicationId);
            return isDelete;
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return false;
    }
}
