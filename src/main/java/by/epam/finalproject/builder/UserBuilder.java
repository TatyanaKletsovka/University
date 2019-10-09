package by.epam.finalproject.builder;

import by.epam.finalproject.entity.ROLE;
import by.epam.finalproject.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements Builder<User> {

    @Override
    public User build(ResultSet resultSet) throws SQLException {
        User user = new User();

        int id = resultSet.getInt("id");
        user.setId(id);

        String login = resultSet.getString("login");
        user.setLogin(login);

        String password = resultSet.getString("password");
        user.setPassword(password);

        String userRoleValue = resultSet.getString("role");
        ROLE role = ROLE.valueOf(userRoleValue.toUpperCase());
        user.setRole(role);

        String firstName = resultSet.getString("firstName");
        user.setFirstName(firstName);

        String lastName = resultSet.getString("lastName");
        user.setLastName(lastName);

        return user;
    }
}
