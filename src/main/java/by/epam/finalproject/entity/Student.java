package by.epam.finalproject.entity;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private int certificate;
    private List<Mark> marks;

    public Student() {
    }

    public Student(int certificate, List<Mark> marks) {
        this.certificate = certificate;
        this.marks = marks;
    }

    public int getCertificate() {
        return certificate;
    }

    public void setCertificate(int certificate) {
        this.certificate = certificate;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public void addMark(Mark mark) {
        if (marks == null) {
            marks = new ArrayList<>();
        }
        marks.add(mark);
    }

    public void removeMark(Mark mark) {
        if (marks != null && marks.contains(mark)) {
            marks.remove(mark);
        }
    }

    @Override
    public String toString() {
        return "Student{" + getLogin() + ", " + getFirstName() + ", " + getLastName() + ", " +
                "certificate=" + certificate +
                ", marks=" + marks +
                '}';
    }
}
