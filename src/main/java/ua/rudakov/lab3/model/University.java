package ua.rudakov.lab3.model;

import java.util.List;

/**
 * Університет - підрозділ найвищого рівня, складається з факультетів.
 */
public class University extends AbstractUnit<Faculty> {

    public University(String name, Human head) {
        super(name, head);
    }

    public void addFaculty(Faculty faculty) {
        addMember(faculty);
    }

    public List<Faculty> getFaculties() {
        return getMembers();
    }
}
