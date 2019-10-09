package by.epam.finalproject.service;

import by.epam.finalproject.dao.FacultyDao;
import by.epam.finalproject.entity.Faculty;

import java.util.List;
import java.util.Map;

public class FacultyService {

    public List<Faculty> findAll() {
        FacultyDao facultyDao = new FacultyDao();
        return facultyDao.findAll();
    }

    public Faculty findFaculty(String id) {
        FacultyDao facultyDao = new FacultyDao();
        return facultyDao.selectEntityById(id);
    }
}
