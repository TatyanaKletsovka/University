package by.epam.finalproject.service;

import by.epam.finalproject.dao.MarkDao;
import by.epam.finalproject.exception.DaoException;


public class MarkService {

    public boolean isUpdate(String userId, String subjectId, String value) throws DaoException {
        MarkDao markDao = new MarkDao();
        if (markDao.findMark(userId, subjectId) != null) {
            return markDao.updateMark(value, userId, subjectId);

        } else {
            return markDao.insertIntoMark(userId, subjectId, value);

        }
    }
}
