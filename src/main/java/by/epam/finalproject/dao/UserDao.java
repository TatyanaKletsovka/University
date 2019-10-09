package by.epam.finalproject.dao;

import by.epam.finalproject.builder.UserBuilder;
import by.epam.finalproject.entity.ROLE;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao extends AbstractDao<Integer, User> {

    private static final String LOGIN_COLUMN = "login";
    private static final String PASSWORD_COLUMN = "password";
    private static final String ROLE_COLUMN = "role";

    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SELECT_USER_BY_LOGIN_AND_PASSWORD =
            "SELECT * FROM user WHERE login = ? and password = ?";
    private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE login = ?";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String INSERT_INTO_USER =
            "INSERT INTO user (login, password, firstName, lastName) values (?, ?, ?, ?)";
    private static final String SELECT_USERS_WHERE_LOGIN =
            "SELECT * FROM user WHERE login = ?";
    private static final String UPDATE_USER_WHERE_ID =
            "UPDATE user SET certificate = ? WHERE user.id = ?";

    @Override
    public List<User> findAll() {
        try {
            List<User> users = executeQuery(SELECT_ALL_USERS, new UserBuilder());
/*            Map<Integer, User> allUsers = new HashMap<>();
            for (int i = 0; i < users.size(); i++) {
                allUsers.put(users.get(i).getId(), users.get(i));
            }*/
            return users;
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

 //   @Override
    public User selectEntityById(Integer id) {
        return null;
    }

    public User selectUserByLoginAndPassword(String login, String password) {
        try {
            List<User> users = executeQuery(SELECT_USER_BY_LOGIN_AND_PASSWORD, new UserBuilder(), login, password);
            if (users.size() > 0) {
                return users.get(0);
            } else {
                return null;
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkLoginForUnique(String login) throws DaoException {

        try {
            List<User> users = executeQuery(SELECT_USER_BY_LOGIN, new UserBuilder(), login);
            if (users.size() == 0) {
                return true;
            } else {
                return false;
            }

        } catch (DaoException e) {
            throw new DaoException(e);
        }
    }

    public User registerUser(String login, String password, String firstName, String lastName) {
        try {
            boolean isUpdate = executeUpdate(INSERT_INTO_USER,
                    login, password, firstName, lastName);
            if (isUpdate) {
                List<User> users = executeQuery(SELECT_USER_BY_LOGIN, new UserBuilder(), login);
                return users.get(0);
            }

        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUserCertificate(String certificate, String id) {
        try {
            boolean isUpdate = executeUpdate(UPDATE_USER_WHERE_ID,
                    certificate, id);
            return isUpdate;
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return false;
    }

/*    public User selectUserByLoginAndPassword(String login, String password) {
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
    }*/

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
