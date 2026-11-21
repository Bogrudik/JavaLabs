package ua.rudakov.lab4.controller;

import ua.rudakov.lab4.model.Faculty;
import ua.rudakov.lab4.model.Human;
import ua.rudakov.lab4.model.University;

/**
 * Створює університет та заповнює його факультетами.
 */
public class UniversityCreator extends UnitCreator<University, Faculty> {

    private final String universityName;

    public UniversityCreator(String universityName, FacultyCreator facultyCreator,
                             HumanCreator headCreator, int facultyCount) {
        super(facultyCreator, headCreator, facultyCount);
        this.universityName = universityName;
    }

    @Override
    protected String generateName(int number) {
        return universityName;
    }

    @Override
    protected University instantiate(String name, Human head) {
        return new University(name, head);
    }
}
