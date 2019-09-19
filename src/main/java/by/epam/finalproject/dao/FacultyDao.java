package by.epam.finalproject.dao;

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
            "SELECT faculty.id, faculty.name, places, passing_points, subject.name FROM faculty " +
                    "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
                    "JOIN subject ON subjects_in_faculty.subject_id = subject.id";
    private static final String SELECT_FACULTY_BY_NAME =
            "SELECT faculty.id, faculty.name, places, passing_points, subject.name FROM faculty " +
                    "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
                    "JOIN subject ON subjects_in_faculty.subject_id = subject.id WHERE name = ?";

    @Override
    public Map<Integer, Faculty> findAll() {
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
        return faculties;
    }



    @Override
    public Faculty selectEntityById(Integer id) {
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
}
