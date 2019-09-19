package by.epam.finalproject.service;

import by.epam.finalproject.dao.UserDao;
import by.epam.finalproject.entity.User;

public class UserService {

    public User login(String login, String password) {
        UserDao userDao = new UserDao();
        return userDao.selectUserByLoginAndPassword(login, password);
    }
}
