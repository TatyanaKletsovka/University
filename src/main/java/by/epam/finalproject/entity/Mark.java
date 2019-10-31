package by.epam.finalproject.entity;

import java.util.Objects;

public class Mark extends Entity{

    private Subject subject;
    private int value;

    public Mark() {
    }

    public Mark(int value) {
        this.value = value;
    }

    public Mark(Subject subject, int value) {
        this.subject = subject;
        this.value = value;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mark mark = (Mark) o;
        return value == mark.value &&
                subject.equals(mark.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject, value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
