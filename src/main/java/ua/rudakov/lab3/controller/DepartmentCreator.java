package ua.rudakov.lab3.controller;

import ua.rudakov.lab3.model.Department;
import ua.rudakov.lab3.model.Group;
import ua.rudakov.lab3.model.Human;

/**
 * Створює кафедри та заповнює їх групами.
 */
public class DepartmentCreator extends UnitCreator<Department, Group> {

    private static final String[] DEPARTMENT_NAMES = {
        "Кафедра системного аналізу та управління",
        "Кафедра програмного забезпечення комп'ютерних систем",
        "Кафедра інформаційних технологій та комп'ютерної інженерії",
        "Кафедра вищої математики",
        "Кафедра електроенергетики",
        "Кафедра автоматизації та комп'ютерних систем",
        "Кафедра економічного аналізу та фінансів",
        "Кафедра маркетингу"
    };

    public DepartmentCreator(GroupCreator groupCreator, HumanCreator headCreator, int groupCount) {
        super(groupCreator, headCreator, groupCount);
    }

    @Override
    protected String generateName(int number) {
        return nameFromPool(DEPARTMENT_NAMES, number);
    }

    @Override
    protected Department instantiate(String name, Human head) {
        return new Department(name, head);
    }
}
