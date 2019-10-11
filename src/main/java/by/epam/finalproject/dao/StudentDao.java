package by.epam.finalproject.dao;

import by.epam.finalproject.builder.StudentBuilder;
import by.epam.finalproject.entity.Student;
import by.epam.finalproject.exception.DaoException;

import java.util.List;

public class StudentDao extends AbstractDao<String, Student>{

    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SELECT_USER_BY_ID =
            "SELECT * FROM user WHERE id = ?";

    public Student findById(String id) throws DaoException {

        List<Student> users = executeQuery(SELECT_USER_BY_ID, new StudentBuilder(), id);
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Student> findAll() throws DaoException {
        return null;
    }

    @Override
    public boolean delete(String id) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Student entity) throws DaoException {
        return false;
    }

    @Override
    public boolean create(Student entity) throws DaoException {
        return false;
    }

    @Override
    public Student update(Student entity) throws DaoException {
        return null;
    }


}
