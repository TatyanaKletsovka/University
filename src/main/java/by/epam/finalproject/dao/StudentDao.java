package by.epam.finalproject.dao;

import by.epam.finalproject.builder.StudentBuilder;
import by.epam.finalproject.entity.Student;
import by.epam.finalproject.exception.DaoException;

import java.sql.ResultSet;
import java.util.List;

public class StudentDao extends AbstractDao<Integer, Student>{

    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SELECT_USER_BY_ID =
            "SELECT * FROM user WHERE id = ?";

    public Student selectStudentById(String id) {
        try {
            List<Student> users = executeQuery(SELECT_USER_BY_ID, new StudentBuilder(), id);
            if (users.size() > 0) {
                return users.get(0);
            } else {
                return null;
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Student entity) {
        return false;
    }

    @Override
    public boolean create(Student entity) {
        return false;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }

    @Override
    protected Student buildEntity(ResultSet resultSet) throws DaoException {
        return null;
    }
}
