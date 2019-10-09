package by.epam.finalproject.entity;

public class Mark extends Entity{

    private Subject subject;
    private int value;

    public Mark() {
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
    public String toString() {
        return String.valueOf(value);
    }
}
