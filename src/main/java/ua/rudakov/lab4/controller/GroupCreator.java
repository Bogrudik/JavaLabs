package ua.rudakov.lab4.controller;

import ua.rudakov.lab4.model.Group;
import ua.rudakov.lab4.model.Human;
import ua.rudakov.lab4.model.Student;

/**
 * Створює академічні групи та заповнює їх студентами.
 */
public class GroupCreator extends UnitCreator<Group, Student> {

    private static final String GROUP_PREFIX = "124-23-";

    public GroupCreator(StudentCreator studentCreator, HumanCreator headCreator, int studentCount) {
        super(studentCreator, headCreator, studentCount);
    }

    @Override
    protected String generateName(int number) {
        return GROUP_PREFIX + number;
    }

    @Override
    protected Group instantiate(String name, Human head) {
        return new Group(name, head);
    }
}
