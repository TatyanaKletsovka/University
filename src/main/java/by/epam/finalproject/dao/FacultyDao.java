package by.epam.finalproject.dao;

import by.epam.finalproject.builder.FacultyBuilder;
import by.epam.finalproject.entity.Faculty;;
import by.epam.finalproject.exception.DaoException;

import java.sql.Connection;
import java.util.*;

public class FacultyDao extends AbstractDao<String, Faculty> {

    private static final String SELECT_ALL_FACULTIES = "SELECT * FROM faculty";
    private static final String SELECT_ALL_FACULTIES_JOIN_SUBJECTS =
            "SELECT faculty.id, faculty.name, places, passing_points, subject.id, subject.name FROM faculty " +
                    "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
                    "JOIN subject ON subjects_in_faculty.subject_id = subject.id";
    private static final String SELECT_FACULTY_JOIN_SUBJECTS_BY_NAME =
            "SELECT faculty.id, faculty.name, places, passing_points, subject.name FROM faculty " +
                    "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
                    "JOIN subject ON subjects_in_faculty.subject_id = subject.id WHERE faculty.name = ?";
    private static final String SELECT_FACULTY_JOIN_SUBJECTS_BY_ID =
            "SELECT faculty.id, faculty.name, places, passing_points, subject.id, subject.name FROM faculty " +
                    "JOIN subjects_in_faculty ON faculty.id = subjects_in_faculty.faculty_id " +
                    "JOIN subject ON subjects_in_faculty.subject_id = subject.id WHERE faculty.id = ?";

    public FacultyDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Faculty> findAll() throws DaoException {

        List<Faculty> allFaculties = executeQuery(SELECT_ALL_FACULTIES_JOIN_SUBJECTS, new FacultyBuilder());
        return createListCurrentFaculties(allFaculties);
    }

    public Faculty findById(String id) throws DaoException {

        List<Faculty> allFaculties = executeQuery(SELECT_FACULTY_JOIN_SUBJECTS_BY_ID, new FacultyBuilder(), id);
        if (allFaculties.size() > 0) {
            List<Faculty> currentFaculties = createListCurrentFaculties(allFaculties);
            return currentFaculties.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(String id) throws DaoException {
        return false;
    }

    private List<Faculty> createListCurrentFaculties(List<Faculty> allFaculties) {

        List<Faculty> currentFaculties = new ArrayList<>();
        for (int i = 0; i < allFaculties.size();) {
            Faculty faculty = allFaculties.get(i);
            int id = faculty.getId();
            i++;
            while (i < allFaculties.size() && id == allFaculties.get(i).getId()) {
                faculty.addSubject(allFaculties.get(i).getSubjects().get(0));
                i++;
            }

            currentFaculties.add(faculty);
        }
        return currentFaculties;
    }
}
