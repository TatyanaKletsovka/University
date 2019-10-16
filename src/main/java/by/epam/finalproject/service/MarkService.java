package by.epam.finalproject.service;

import by.epam.finalproject.dao.MarkDao;
import by.epam.finalproject.exception.DaoException;

import java.sql.Connection;


public class MarkService {

    Connection connection;
    MarkDao markDao;

    public MarkService(Connection connection) {
        this.connection = connection;
        markDao = new MarkDao(connection);
    }

    public boolean isUpdate(String userId, String subjectId, String value) throws DaoException {
        if (markDao.findMark(userId, subjectId) != null) {
            return markDao.updateMark(value, userId, subjectId);

        } else {
            return markDao.insertIntoMark(userId, subjectId, value);
        }
    }
}
