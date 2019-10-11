package by.epam.finalproject.service;

import by.epam.finalproject.dao.FacultyDao;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.exception.DaoException;

import java.util.List;
import java.util.Map;

public class FacultyService {

    public List<Faculty> findAll() throws DaoException {
        FacultyDao facultyDao = new FacultyDao();
        return facultyDao.findAll();
    }

    public Faculty findFaculty(String id) throws DaoException{
        FacultyDao facultyDao = new FacultyDao();
        return facultyDao.findById(id);
    }
}
