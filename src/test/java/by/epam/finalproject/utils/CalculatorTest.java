package by.epam.finalproject.utils;

import by.epam.finalproject.entity.Mark;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CalculatorTest {


    @Test
    public void buildSumMarksWithMarksInList() {
        //given
        List<Mark> marks = new ArrayList<>
                (Arrays.asList(new Mark(87), new Mark(80), new Mark(70)));
        int expected = 237;
        //when
        int actual = Calculator.buildSumMarks(marks);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void buildSumMarksWithEmptyList() {
        //given
        List<Mark> marks = new ArrayList<>();
        int expected = 0;
        //when
        int actual = Calculator.buildSumMarks(marks);
        //then
        Assert.assertEquals(expected, actual);
    }
}