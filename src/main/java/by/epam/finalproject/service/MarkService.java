package by.epam.finalproject.service;

import by.epam.finalproject.dao.MarkDao;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.exception.ServiceException;

import java.sql.Connection;


public class MarkService {

    Connection connection;
    MarkDao markDao;

    public MarkService(Connection connection) {
        this.connection = connection;
        markDao = new MarkDao(connection);
    }

    public boolean isUpdate(String userId, String subjectId, String value) throws ServiceException {
        try {
            if (markDao.findMark(userId, subjectId) != null) {
                return markDao.updateMark(value, userId, subjectId);

            } else {
                return markDao.insertIntoMark(userId, subjectId, value);
            }
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}
