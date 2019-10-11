package by.epam.finalproject.entity;

import java.time.LocalDate;

public class Application extends Entity{

    private Faculty faculty;
    private Student student;
    private STATUS status;
    private LocalDate dateTime;

    public Application() {
    }

    public Application(Faculty faculty, Student student) {
        this.faculty = faculty;
        this.student = student;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Application" + getId() + "{" +
                "faculty=" + faculty +
                ", student=" + student +
                ", status=" + status +
                ", dateTime=" + dateTime +
                '}';
    }
}
