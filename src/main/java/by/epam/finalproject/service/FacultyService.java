package by.epam.finalproject.service;

import by.epam.finalproject.dao.FacultyDao;
import by.epam.finalproject.entity.Faculty;

import java.util.Map;

public class FacultyService {

    public Map<Integer, Faculty> findAll() {
        FacultyDao facultyDao = new FacultyDao();
        return facultyDao.findAll();
    }
}
