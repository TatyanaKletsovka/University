package by.epam.finalproject.entity;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends Entity{

    private String name;
    private int places;
    private int passingPoints;
    private List<Subject> subjects;

    public Faculty() {
    }

    public Faculty(int id, String name, int places, int passingPoints, List<Subject> subjects) {
        setId(id);
        this.name = name;
        this.places = places;
        this.passingPoints = passingPoints;
        this.subjects = subjects;
    }

    public Faculty(int id, String name, int places, int passingPoints) {
        setId(id);
        this.name = name;
        this.places = places;
        this.passingPoints = passingPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getPassingPoints() {
        return passingPoints;
    }

    public void setPassingPoints(int passingPoints) {
        this.passingPoints = passingPoints;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject) {
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        if (subjects != null && subjects.contains(subject)) {
            subjects.remove(subject);
        }
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", places=" + places +
                ", passingPoints=" + passingPoints +
                ", subjects=" + subjects +
                '}';
    }
}
