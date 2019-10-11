package by.epam.finalproject.service;

import by.epam.finalproject.dao.ApplicationDao;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.exception.DaoException;
import org.apache.log4j.Logger;

import java.util.List;

public class ApplicationService {

    private final static Logger LOGGER = Logger.getLogger(ApplicationService.class);

    public boolean createApplication(String facultyId, String userId) throws DaoException {
        ApplicationDao applicationDao = new ApplicationDao();
        return applicationDao.createApplication(facultyId, userId);
    }

    public List<Application> findAll() throws DaoException{
        ApplicationDao applicationDao = new ApplicationDao();
        return applicationDao.findAll();
    }

    public List<Application> findAllWhereUserLogin(String login) throws DaoException{
        ApplicationDao applicationDao = new ApplicationDao();
        return applicationDao.findAllWhereUserLogin(login);
    }

    public List<Application> findAllWhereFacultyId(String facultyId) throws DaoException{
        ApplicationDao applicationDao = new ApplicationDao();
        return applicationDao.findAllWhereFacultyId(facultyId);
    }

    public boolean deleteApplicationWhereId(String applicationId) throws DaoException{
        ApplicationDao applicationDao = new ApplicationDao();
        return applicationDao.delete(applicationId);
    }

    public void updateApplicationStatus(List<Application> applications) throws DaoException{
        ApplicationDao applicationDao = new ApplicationDao();
        for (int i = 0; i < applications.size(); i++) {
            String status = applications.get(i).getStatus().toString();
            String applicationId = String.valueOf(applications.get(i).getId());
            LOGGER.info("Application: " + applicationId + " go to DAO");
            applicationDao.updateApplicationStatus(status, applicationId);
        }
    }

}
