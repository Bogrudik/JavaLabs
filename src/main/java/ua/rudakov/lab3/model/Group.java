package ua.rudakov.lab3.model;

import java.util.List;

/**
 * Академічна група - складається зі студентів.
 */
public class Group extends AbstractUnit<Student> {

    public Group(String name, Human head) {
        super(name, head);
    }

    public void addStudent(Student student) {
        addMember(student);
    }

    public List<Student> getStudents() {
        return getMembers();
    }

    @Override
    public String toString() {
        return "Група " + super.toString();
    }
}
