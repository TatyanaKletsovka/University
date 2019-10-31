package by.epam.finalproject.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Application extends Entity{

    private Faculty faculty;
    private Student student;
    private Status status;
    private LocalDateTime dateTime;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Application that = (Application) o;
        return faculty.equals(that.faculty) &&
                student.equals(that.student) &&
                status == that.status &&
                dateTime.equals(that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty, student, status, dateTime);
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
