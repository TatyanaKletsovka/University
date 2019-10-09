package by.epam.finalproject.service;

import by.epam.finalproject.dao.MarkDao;


public class MarkService {

    public boolean isUpdate(String userId, String subjectId, String value) {
        MarkDao markDao = new MarkDao();
        if (markDao.findMark(userId, subjectId) != null) {
            return markDao.updateMark(value, userId, subjectId);

        } else {
            return markDao.insertIntoMark(userId, subjectId, value);

        }
    }
}
