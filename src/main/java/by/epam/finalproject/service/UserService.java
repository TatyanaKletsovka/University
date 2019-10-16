package by.epam.finalproject.service;

import by.epam.finalproject.dao.UserDao;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;

import java.sql.Connection;
import java.util.List;

public class UserService {

    Connection connection;
    UserDao userDao;

    public UserService(Connection connection) {
        this.connection = connection;
        userDao = new UserDao(connection);
    }

    public User checkLoginAndPassword(String login, String password) throws DaoException{
        return userDao.selectUserByLoginAndPassword(login, password);
    }

    public boolean checkUserLoginForUnique(String login) throws DaoException {
        return userDao.checkLoginForUnique(login);
    }

    public User register(String login, String password, String firstName, String lastName) throws DaoException{
        return userDao.registerUser(login, password, firstName, lastName);
    }

    public boolean isUpdateCertificate(String certificate, String id) throws DaoException{
        return userDao.updateUserCertificate(certificate, id);
    }

    public List<User> findAll() throws DaoException{
        return userDao.findAll();
    }
}
