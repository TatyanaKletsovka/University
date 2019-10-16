package by.epam.finalproject.service;

import by.epam.finalproject.dao.StudentDao;
import by.epam.finalproject.entity.Student;
import by.epam.finalproject.exception.DaoException;

import java.sql.Connection;

public class StudentService {

    Connection connection;
    StudentDao studentDao;

    public StudentService(Connection connection) {
        this.connection = connection;
        studentDao = new StudentDao(connection);
    }

    public Student selectStudentById(String id) throws DaoException {
        return studentDao.findById(id);
    }
}
