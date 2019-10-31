package by.epam.finalproject.service;

import by.epam.finalproject.dao.StudentDao;
import by.epam.finalproject.entity.Student;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.exception.ServiceException;

import java.sql.Connection;

public class StudentService {

    Connection connection;
    StudentDao studentDao;

    public StudentService(Connection connection) {
        this.connection = connection;
        studentDao = new StudentDao(connection);
    }

    public Student selectStudentById(String id) throws ServiceException {
        try {
            return studentDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
