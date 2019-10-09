package by.epam.finalproject.builder;

import by.epam.finalproject.entity.Mark;
import by.epam.finalproject.entity.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkBuilder implements Builder<Mark> {
    @Override
    public Mark build(ResultSet resultSet) throws SQLException {
        Mark mark = new Mark();

        int id = resultSet.getInt("mark.id");
        mark.setId(id);

        int value = resultSet.getInt("value");
        mark.setValue(value);

        Subject subject = new Subject();

        int subjectId = resultSet.getInt("subject.id");
        subject.setId(subjectId);

        mark.setSubject(subject);

        return mark;
    }
}
