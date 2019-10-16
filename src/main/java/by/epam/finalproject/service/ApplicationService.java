package by.epam.finalproject.service;

import by.epam.finalproject.dao.ApplicationDao;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.exception.DaoException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class ApplicationService {

    private final static Logger LOGGER = Logger.getLogger(ApplicationService.class);

    Connection connection;
    ApplicationDao applicationDao;

    public ApplicationService(Connection connection) {
        this.connection = connection;
        applicationDao = new ApplicationDao(connection);
    }

    public boolean createApplication(String facultyId, String userId) throws DaoException {
        return applicationDao.createApplication(facultyId, userId);
    }

    public List<Application> findAll() throws DaoException{
        return applicationDao.findAll();
    }

    public List<Application> findAllWhereUserLogin(String login) throws DaoException{
        return applicationDao.findAllWhereUserLogin(login);
    }

    public List<Application> findAllWhereFacultyId(String facultyId) throws DaoException{
        return applicationDao.findAllWhereFacultyId(facultyId);
    }

    public boolean deleteApplicationWhereId(String applicationId) throws DaoException{
        return applicationDao.delete(applicationId);
    }

    public void updateApplicationStatus(List<Application> applications) throws DaoException{
        for (int i = 0; i < applications.size(); i++) {
            String status = applications.get(i).getStatus().toString();
            String applicationId = String.valueOf(applications.get(i).getId());
            LOGGER.info("Application: " + applicationId + " go to DAO");
            applicationDao.updateApplicationStatus(status, applicationId);
        }
    }

}
