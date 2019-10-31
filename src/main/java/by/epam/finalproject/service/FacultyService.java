package by.epam.finalproject.service;

import by.epam.finalproject.dao.FacultyDao;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class FacultyService {

    Connection connection;
    FacultyDao facultyDao;

    public FacultyService(Connection connection) {
        this.connection = connection;
        facultyDao = new FacultyDao(connection);
    }

    public List<Faculty> findAll() throws ServiceException {
        try {
            return facultyDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Faculty findFaculty(String id) throws ServiceException{
        try {
            return facultyDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
