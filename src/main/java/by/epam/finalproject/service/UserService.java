package by.epam.finalproject.service;

import by.epam.finalproject.dao.UserDao;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class UserService {

    Connection connection;
    UserDao userDao;

    public UserService(Connection connection) {
        this.connection = connection;
        userDao = new UserDao(connection);
    }

    public User checkLoginAndPassword(String login, String password) throws ServiceException {
        try {
            return userDao.selectUserByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean checkUserLoginForUnique(String login) throws ServiceException {
        try {
            return userDao.checkLoginForUnique(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public User register(String login, String password, String firstName, String lastName) throws ServiceException{
        try {
            return userDao.registerUser(login, password, firstName, lastName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean isUpdateCertificate(String certificate, String id) throws ServiceException{
        try {
            return userDao.updateUserCertificate(certificate, id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> findAll() throws ServiceException{
        try {
            return userDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
