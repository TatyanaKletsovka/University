package by.epam.finalproject.dao;

import by.epam.finalproject.entity.ROLE;
import by.epam.finalproject.entity.STATUS;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserDao extends AbstractDao<Integer, User> {

    private static final String LOGIN_COLUMN = "login";
    private static final String PASSWORD_COLUMN = "password";
    private static final String ROLE_COLUMN = "role";

    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SELECT_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT id, login, password, role FROM user WHERE login = ? and password = ?";

    @Override
    public Map<Integer, User> findAll() {
        return null;
    }

    @Override
    public User selectEntityById(Integer id) {
        return null;
    }

    public User selectUserByLoginAndPassword(String login, String password) {
        User user = null;
        PreparedStatement statement = getPrepareStatement(SELECT_USER_BY_LOGIN_AND_PASSWORD);
        try {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(statement);
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    protected User buildEntity(ResultSet resultSet) throws DaoException {
        try {
            User user = new User();

            int id = resultSet.getInt(ID_COLUMN);
            user.setId(id);

            String login = resultSet.getString(LOGIN_COLUMN);
            user.setLogin(login);

            String password = resultSet.getString(PASSWORD_COLUMN);
            user.setPassword(password);

            String userRoleValue = resultSet.getString(ROLE_COLUMN);
            ROLE role = ROLE.valueOf(userRoleValue.toUpperCase());
            user.setRole(role);

            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
