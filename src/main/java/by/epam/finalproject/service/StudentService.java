package by.epam.finalproject.service;

import by.epam.finalproject.dao.StudentDao;
import by.epam.finalproject.entity.Student;

public class StudentService {

    public Student selectStudentById(String id) {
        StudentDao studentDao = new StudentDao();
        return studentDao.selectStudentById(id);
    }
}
