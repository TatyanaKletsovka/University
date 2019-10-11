package by.epam.finalproject.utils;

import by.epam.finalproject.entity.Mark;

import java.util.List;

public class Calculator {

    public static int buildSumMarks (List<Mark> marks) {
        if (marks.size() == 0) {
            return 0;
        }
        int sumMarks = 0;
        for (int i = 0; i < marks.size(); i++) {
            sumMarks += marks.get(i).getValue();
        }
        return sumMarks;
    }
}
