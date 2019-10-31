package by.epam.finalproject.dao;

import by.epam.finalproject.builder.UserBuilder;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;

import java.sql.Connection;
import java.util.List;

public class UserDao extends AbstractDao<String, User> {

    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SELECT_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT * FROM user WHERE login = ? and password = ?";
    private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE login = ?";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String INSERT_INTO_USER =
            "INSERT INTO user (login, password, firstName, lastName) values (?, ?, ?, ?)";
    private static final String UPDATE_USER_WHERE_ID =
            "UPDATE user SET certificate = ? WHERE user.id = ?";


    public UserDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> findAll() throws DaoException{

        List<User> users = executeQuery(SELECT_ALL_USERS, new UserBuilder());
        return users;
    }

    public User selectUserByLoginAndPassword(String login, String password) throws DaoException{

        List<User> users = executeQuery(SELECT_USER_BY_LOGIN_AND_PASSWORD, new UserBuilder(), login, password);
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public boolean checkLoginForUnique(String login) throws DaoException {

        List<User> users = executeQuery(SELECT_USER_BY_LOGIN, new UserBuilder(), login);
        if (users.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public User registerUser(String login, String password, String firstName, String lastName) throws DaoException{

        boolean isUpdate = executeUpdate(INSERT_INTO_USER,
                login, password, firstName, lastName);
        if (isUpdate) {
            List<User> users = executeQuery(SELECT_USER_BY_LOGIN, new UserBuilder(), login);
            if (users.size() > 0) {
                return users.get(0);
            }
        }
        return null;

    }

    public boolean updateUserCertificate(String certificate, String id) throws DaoException{

        boolean isUpdate = executeUpdate(UPDATE_USER_WHERE_ID, certificate, id);
        return isUpdate;
    }

    public User findById(String id) throws DaoException{
        List<User> users = executeQuery(SELECT_USER_BY_ID, new UserBuilder(), id);
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

}
