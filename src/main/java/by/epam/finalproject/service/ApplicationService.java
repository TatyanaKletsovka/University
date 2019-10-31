package by.epam.finalproject.service;

import by.epam.finalproject.dao.ApplicationDao;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class ApplicationService {

    Connection connection;
    ApplicationDao applicationDao;

    public ApplicationService(Connection connection) {
        this.connection = connection;
        applicationDao = new ApplicationDao(connection);
    }

    public boolean createApplication(String facultyId, String userId) throws ServiceException {
        try {
            return applicationDao.createApplication(facultyId, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Application> findAll() throws ServiceException{
        try {
            return applicationDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Application> findAllWhereUserLogin(String login) throws ServiceException{
        try {
            return applicationDao.findAllWhereUserLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Application> findAllWhereFacultyId(String facultyId) throws ServiceException{
        try {
            return applicationDao.findAllWhereFacultyId(facultyId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean deleteApplicationWhereId(String applicationId) throws ServiceException{
        try {
            return applicationDao.delete(applicationId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void updateApplicationStatus(List<Application> applications) throws ServiceException{
        for (int i = 0; i < applications.size(); i++) {
            String status = applications.get(i).getStatus().toString();
            String applicationId = String.valueOf(applications.get(i).getId());
            try {
                applicationDao.updateApplicationStatus(status, applicationId);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
    }
}
