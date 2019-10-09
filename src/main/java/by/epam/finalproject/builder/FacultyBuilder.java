package by.epam.finalproject.builder;

import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.entity.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyBuilder implements Builder<Faculty> {

    @Override
    public Faculty build(ResultSet resultSet) throws SQLException {
        Faculty faculty = new Faculty();

        int id = resultSet.getInt("faculty.id");
        faculty.setId(id);

        String name = resultSet.getString("faculty.name");
        faculty.setName(name);

        int places = resultSet.getInt("places");
        faculty.setPlaces(places);

        int passingPoints = resultSet.getInt("passing_points");
        faculty.setPassingPoints(passingPoints);

        Subject subject = new Subject();

        int subjectId = resultSet.getInt("subject.id");
        subject.setId(subjectId);

        String subjectName = resultSet.getString("subject.name");
        subject.setName(subjectName);

        faculty.addSubject(subject);

        return faculty;
    }
}
