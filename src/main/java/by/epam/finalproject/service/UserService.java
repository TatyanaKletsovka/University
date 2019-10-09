package by.epam.finalproject.service;

import by.epam.finalproject.dao.UserDao;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;

import java.util.List;

public class UserService {

    public User checkLoginAndPassword(String login, String password) {
        UserDao userDao = new UserDao();
        return userDao.selectUserByLoginAndPassword(login, password);
    }

    public boolean checkUserLoginForUnique(String login) throws DaoException {
        UserDao userDao = new UserDao();
        return userDao.checkLoginForUnique(login);
    }

    public User register(String login, String password, String firstName, String lastName) {
        UserDao userDao = new UserDao();
        return userDao.registerUser(login, password, firstName, lastName);
    }

    public boolean isUpdateCertificate(String certificate, String id) {
        UserDao userDao = new UserDao();
        return userDao.updateUserCertificate(certificate, id);
    }

    public List<User> findAll() {
        UserDao userDao = new UserDao();
        return userDao.findAll();
    }
}
