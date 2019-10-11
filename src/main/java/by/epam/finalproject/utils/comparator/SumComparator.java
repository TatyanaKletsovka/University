package by.epam.finalproject.utils.comparator;

import by.epam.finalproject.entity.Application;
import by.epam.finalproject.entity.Student;
import by.epam.finalproject.utils.Calculator;

import java.util.Comparator;

public class SumComparator implements Comparator<Application> {

    @Override
    public int compare(Application app1, Application app2) {
        Student student1 = app1.getStudent();
        Student student2 = app2.getStudent();
        int sum1 = student1.getCertificate() + Calculator.buildSumMarks(student1.getMarks());
        int sum2 = student2.getCertificate() + Calculator.buildSumMarks(student2.getMarks());
        return Integer.compare(sum2, sum1);
    }
}
