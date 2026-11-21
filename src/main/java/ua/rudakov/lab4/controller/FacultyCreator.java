package ua.rudakov.lab4.controller;

import ua.rudakov.lab4.model.Department;
import ua.rudakov.lab4.model.Faculty;
import ua.rudakov.lab4.model.Human;

/**
 * Створює факультети та заповнює їх кафедрами.
 */
public class FacultyCreator extends UnitCreator<Faculty, Department> {

    private static final String[] FACULTY_NAMES = {
        "Факультет інформаційних технологій",
        "Факультет електроенергетики",
        "Факультет менеджменту",
        "Механіко-машинобудівний факультет"
    };

    public FacultyCreator(DepartmentCreator departmentCreator, HumanCreator headCreator,
                          int departmentCount) {
        super(departmentCreator, headCreator, departmentCount);
    }

    @Override
    protected String generateName(int number) {
        return nameFromPool(FACULTY_NAMES, number);
    }

    @Override
    protected Faculty instantiate(String name, Human head) {
        return new Faculty(name, head);
    }
}
