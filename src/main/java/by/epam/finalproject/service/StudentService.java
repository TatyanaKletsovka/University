package by.epam.finalproject.service;

import by.epam.finalproject.dao.StudentDao;
import by.epam.finalproject.entity.Student;
import by.epam.finalproject.exception.DaoException;

public class StudentService {

    public Student selectStudentById(String id) throws DaoException {
        StudentDao studentDao = new StudentDao();
        return studentDao.findById(id);
    }
}
