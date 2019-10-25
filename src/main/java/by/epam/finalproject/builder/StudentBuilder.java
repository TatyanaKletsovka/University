package by.epam.finalproject.builder;

import by.epam.finalproject.entity.Role;
import by.epam.finalproject.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentBuilder implements Builder<Student> {

    @Override
    public Student build(ResultSet resultSet) throws SQLException {
        Student student = new Student();

        int id = resultSet.getInt("id");
        student.setId(id);

        String login = resultSet.getString("login");
        student.setLogin(login);

        String password = resultSet.getString("password");
        student.setPassword(password);

        String userRoleValue = resultSet.getString("role");
        Role role = Role.valueOf(userRoleValue.toUpperCase());
        student.setRole(role);

        String firstName = resultSet.getString("firstName");
        student.setFirstName(firstName);

        String lastName = resultSet.getString("lastName");
        student.setLastName(lastName);

        String certificate = resultSet.getString("certificate");
        student.setCertificate(Integer.parseInt(certificate));

        return student;
    }
}