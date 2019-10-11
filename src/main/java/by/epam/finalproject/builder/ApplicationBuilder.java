package by.epam.finalproject.builder;

import by.epam.finalproject.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ApplicationBuilder implements Builder<Application> {

    @Override
    public Application build(ResultSet resultSet) throws SQLException {
        Application application = new Application();

        int applicationId = resultSet.getInt("application.id");
        application.setId(applicationId);


        Faculty faculty = new Faculty();

        int facultyId = resultSet.getInt("faculty.id");
        faculty.setId(facultyId);

        String facultyName = resultSet.getString("faculty.name");
        faculty.setName(facultyName);

        int places = resultSet.getInt("places");
        faculty.setPlaces(places);

        int passingPoints = resultSet.getInt("passing_points");
        faculty.setPassingPoints(passingPoints);

        application.setFaculty(faculty);


        Student student = new Student();
        String login = resultSet.getString("login");
        student.setLogin(login);

        String firstName = resultSet.getString("firstName");
        student.setFirstName(firstName);

        String lastName = resultSet.getString("lastName");
        student.setLastName(lastName);

        int certificate = resultSet.getInt("certificate");
        student.setCertificate(certificate);

        application.setStudent(student);

        Mark mark = new Mark();
        int markValue = resultSet.getInt("mark.value");
        mark.setValue(markValue);

        student.addMark(mark);

        String applyStatus = resultSet.getString("status");
        STATUS status = STATUS.valueOf(applyStatus.toUpperCase());
        application.setStatus(status);

  //      Date date = new Date();
        String dateOfRegister = resultSet.getString("date_of_register");

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //    DateTimeFormatter dt = formatter2.parse(Character[dateOfRegister]);


  //      String dateInString = "Mon, 05 May 1980";
  //      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy");
        LocalDate dateTime = LocalDate.parse(dateOfRegister, formatter2);
        application.setDateTime(dateTime);

        return application;
    }
}
