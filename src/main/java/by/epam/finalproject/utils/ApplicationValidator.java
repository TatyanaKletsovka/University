package by.epam.finalproject.utils;

import by.epam.finalproject.entity.Application;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.entity.Student;

public class ApplicationValidator {

    public boolean validateByPassingPoints (Application application) {
        Student student = application.getStudent();
        int totalScore = student.getCertificate() + Calculator.buildSumMarks(student.getMarks());
        Faculty faculty = application.getFaculty();
        int passingPoints = faculty.getPassingPoints();
        if (totalScore >= passingPoints) {
            return true;
        } else {
            return false;
        }
    }
}
