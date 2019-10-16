package by.epam.finalproject.service;

import by.epam.finalproject.dao.FacultyDao;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.exception.DaoException;

import java.sql.Connection;
import java.util.List;

public class FacultyService {

    Connection connection;
    FacultyDao facultyDao;

    public FacultyService(Connection connection) {
        this.connection = connection;
        facultyDao = new FacultyDao(connection);
    }

    public List<Faculty> findAll() throws DaoException {
        return facultyDao.findAll();
    }

    public Faculty findFaculty(String id) throws DaoException{
        return facultyDao.findById(id);
    }
}
