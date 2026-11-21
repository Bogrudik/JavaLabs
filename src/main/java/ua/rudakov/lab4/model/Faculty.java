package ua.rudakov.lab4.model;

import java.util.List;

/**
 * Факультет - складається з кафедр.
 */
public class Faculty extends AbstractUnit<Department> {

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public void addDepartment(Department department) {
        addMember(department);
    }

    public List<Department> getDepartments() {
        return getMembers();
    }
}
