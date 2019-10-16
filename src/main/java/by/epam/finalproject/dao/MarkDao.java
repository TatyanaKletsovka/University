package by.epam.finalproject.dao;

import by.epam.finalproject.builder.MarkBuilder;
import by.epam.finalproject.entity.Mark;
import by.epam.finalproject.exception.DaoException;

import java.sql.Connection;
import java.util.List;

public class MarkDao extends AbstractDao<String, Mark> {

    private static final String INSERT_INTO_MARK =
            "INSERT INTO mark (user_id, subject_id, value) values (?, ?, ?)";
    private static final String SELECT_MARK_BY_ID =
            "SELECT mark.id, value, user.id, subject.id FROM mark " +
            "JOIN user ON mark.user_id = user.id " +
            "JOIN subject ON mark.subject_id = subject.id " +
            "WHERE user.id = ? and subject.id = ?";
    private static final String UPDATE_MARK =
            "UPDATE mark SET value = ? WHERE user_id = ? AND subject_id = ?;";

    public MarkDao(Connection connection) {
        super(connection);
    }

    public boolean insertIntoMark(String userId, String subjectId, String value) throws DaoException {

        boolean isUpdate = executeUpdate(INSERT_INTO_MARK, userId, subjectId, value);
        return isUpdate;
    }

    public Mark findMark(String userId, String subjectId) throws DaoException {

        List<Mark> marks = executeQuery(SELECT_MARK_BY_ID, new MarkBuilder(), userId, subjectId);
        if (marks.size() != 0) {
            return marks.get(0);
        } else {
            return null;
        }
    }

    public boolean updateMark(String value, String userId, String subjectId) throws DaoException {

        boolean isUpdate = executeUpdate(UPDATE_MARK, value, userId, subjectId);
        return isUpdate;
    }

    @Override
    public List<Mark> findAll() throws DaoException {
        return null;
    }

    @Override
    public Mark findById(String id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(String id) throws DaoException {
        return false;
    }
}
