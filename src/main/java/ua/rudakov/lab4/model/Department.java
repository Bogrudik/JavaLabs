package ua.rudakov.lab4.model;

import java.util.List;

/**
 * Кафедра - складається з академічних груп.
 */
public class Department extends AbstractUnit<Group> {

    public Department(String name, Human head) {
        super(name, head);
    }

    public void addGroup(Group group) {
        addMember(group);
    }

    public List<Group> getGroups() {
        return getMembers();
    }
}
