package by.epam.finalproject.service;

import by.epam.finalproject.dao.ApplicationDao;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.exception.DaoException;

import java.util.List;

public class ApplicationService {

    public boolean createApplication(String facultyId, String userId) throws DaoException {
        ApplicationDao applicationDao = new ApplicationDao();
        return applicationDao.createApplication(facultyId, userId);
    }

    public List<Application> findAll() {
        ApplicationDao applicationDao = new ApplicationDao();
        return applicationDao.findAll();
    }

    public List<Application> findAllWhereUserLogin(String login) {
        ApplicationDao applicationDao = new ApplicationDao();
        return applicationDao.findAllWhereUserLogin(login);
    }

    public boolean deleteApplicationWhereId(String applicationId) {
        ApplicationDao applicationDao = new ApplicationDao();
        return applicationDao.deleteApplicationWhereId(applicationId);
    }
}
