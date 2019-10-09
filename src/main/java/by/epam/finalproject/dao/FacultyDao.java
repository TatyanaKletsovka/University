package by.epam.finalproject.dao;

import by.epam.finalproject.builder.FacultyBuilder;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.entity.ROLE;
import by.epam.finalproject.entity.Subject;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.pool.ConnectionPool;

import java.sql.*;
import java.util.*;

public class FacultyDao extends AbstractDao<Integer, Faculty> {

    private static final String SELECT_ALL_FACULTIES = "SELECT * FROM faculty";
    private static final String SELECT_ALL_FACULTIES_JOIN_SUBJECTS =
            "SELECT faculty.id, faculty.name, places, passing_points, subject.id, subject.name FROM faculty " +
                    "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
                    "JOIN subject ON subjects_in_faculty.subject_id = subject.id";
    private static final String SELECT_FACULTY_JOIN_SUBJECTS_BY_NAME =
            "SELECT faculty.id, faculty.name, places, passing_points, subject.name FROM faculty " +
                    "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
                    "JOIN subject ON subjects_in_faculty.subject_id = subject.id WHERE name = ?";
    private static final String SELECT_FACULTY_JOIN_SUBJECTS_BY_ID =
            "SELECT faculty.id, faculty.name, places, passing_points, subject.id, subject.name FROM faculty " +
                    "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
                    "JOIN subject ON subjects_in_faculty.subject_id = subject.id WHERE faculty.id = ?";
    @Override
    public List<Faculty> findAll() {
        try {
            List<Faculty> allFaculties = executeQuery(SELECT_ALL_FACULTIES_JOIN_SUBJECTS, new FacultyBuilder());
            List<Faculty> currentFaculties = createListCurrentFaculties(allFaculties);
            return currentFaculties;
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

/*    @Override
    public List<Faculty> findAll() {
        Map<Integer, Faculty> faculties = new HashMap<>();
        PreparedStatement statement = null;
        try {
            statement = getPrepareStatement(SELECT_ALL_FACULTIES_JOIN_SUBJECTS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Faculty faculty = faculties.get(id);
                Subject subject = new Subject();
                if (faculty == null) {
                    faculty = new Faculty();
                    faculty.setId(id);
                    faculty.setName(resultSet.getString("faculty.name"));
                    faculty.setPlaces(resultSet.getInt("places"));
                    faculty.setPassingPoints(resultSet.getInt("passing_points"));
                    subject.setName(resultSet.getString("subject.name"));
                    faculty.addSubject(subject);
                } else {
                    subject.setName(resultSet.getString("subject.name"));
                    faculty.addSubject(subject);
                }
                faculties.put(id, faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(statement);
        }
//        List<Faculty> faculties1 = new ArrayList<>(faculties.values());
        return new ArrayList<>(faculties.values());
    }*/

 //   @Override
    public Faculty selectEntityById(String id) {
        try {
            List<Faculty> faculties = executeQuery(SELECT_FACULTY_JOIN_SUBJECTS_BY_ID, new FacultyBuilder(), id);
            if (faculties.size() > 0) {
                List<Faculty> currentFaculties = createListCurrentFaculties(faculties);
                return currentFaculties.get(0);
            } else {
                return null;
            }
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
    public boolean delete(Faculty entity) {
        return false;
    }

    @Override
    public boolean create(Faculty entity) {
        return false;
    }

    @Override
    public Faculty update(Faculty entity) {
        return null;
    }

    @Override
    protected Faculty buildEntity(ResultSet resultSet) {
/*        try {
            Faculty faculty = new Faculty();

            int id = resultSet.getInt(ID_COLUMN);
            faculty.setId(id);

            String login = resultSet.getString(LOGIN_COLUMN);
            faculty.setLogin(login);

            String password = resultSet.getString(PASSWORD_COLUMN);
            faculty.setPassword(password);

            String userRoleValue = resultSet.getString(ROLE_COLUMN);
            ROLE role = ROLE.valueOf(userRoleValue.toUpperCase());
            faculty.setRole(role);

            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
        }*/
        return null;
    }

    private List<Faculty> createListCurrentFaculties(List<Faculty> allFaculties) {
        List<Faculty> currentFaculties = new ArrayList<>();
        for (int i = 0; i < allFaculties.size(); i+= 3) {
            //        int id = allfaculties.get(i).getId();
            Faculty faculty = allFaculties.get(i);
            faculty.addSubject(allFaculties.get(i+1).getSubjects().get(0));
            faculty.addSubject(allFaculties.get(i+2).getSubjects().get(0));
            currentFaculties.add(faculty);
        }
        return currentFaculties;
    }
}
