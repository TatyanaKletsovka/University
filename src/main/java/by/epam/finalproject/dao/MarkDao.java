package by.epam.finalproject.dao;

import by.epam.finalproject.builder.MarkBuilder;
import by.epam.finalproject.entity.Mark;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;

import java.sql.ResultSet;
import java.util.List;

public class MarkDao extends AbstractDao<Integer, Mark> {

    private static final String INSERT_INTO_MARK =
            "INSERT INTO mark (user_id, subject_id, value) values (?, ?, ?)";
    private static final String SELECT_MARK_BY_ID =
            "SELECT mark.id, value, user.id, subject.id FROM mark " +
            "JOIN user ON mark.user_id = user.id " +
            "JOIN subject ON mark.subject_id = subject.id " +
            "WHERE user.id = ? and subject.id = ?";
    private static final String UPDATE_MARK =
            "UPDATE mark SET value = ? WHERE user_id = ? AND subject_id = ?;";

    public boolean insertIntoMark(String userId, String subjectId, String value) {
        try {
            boolean isUpdate = executeUpdate(INSERT_INTO_MARK, userId, subjectId, value);
            return isUpdate;
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Mark findMark(String userId, String subjectId) {
        try {
            List<Mark> marks = executeQuery(SELECT_MARK_BY_ID, new MarkBuilder(), userId, subjectId);
            if (marks.size() != 0) {
                return marks.get(0);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateMark(String value, String userId, String subjectId) {
        try {
            boolean isUpdate = executeUpdate(UPDATE_MARK, value, userId, subjectId);
            return isUpdate;
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Mark> findAll() {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Mark entity) {
        return false;
    }

    @Override
    public boolean create(Mark entity) {
        return false;
    }

    @Override
    public Mark update(Mark entity) {
        return null;
    }

    @Override
    protected Mark buildEntity(ResultSet resultSet) throws DaoException {
        return null;
    }
}
