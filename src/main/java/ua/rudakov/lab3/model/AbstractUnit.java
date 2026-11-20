package ua.rudakov.lab3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Базовий клас для всіх підрозділів університету.
 * Зберігає назву, голову підрозділу та список підрозділів нижчого рівня.
 *
 * @param <T> тип підрозділів нижчого рівня (наприклад, для факультету - кафедри)
 */
public abstract class AbstractUnit<T> implements Unit {

    private String name;
    private Human head;
    private List<T> members = new ArrayList<>();

    protected AbstractUnit(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    public void addMember(T member) {
        members.add(member);
    }

    public List<T> getMembers() {
        return Collections.unmodifiableList(members);
    }

    @Override
    public String toString() {
        return name + " (голова: " + head.getFullName() + ")";
    }
}
