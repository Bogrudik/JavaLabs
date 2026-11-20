package ua.rudakov.lab3;

import ua.rudakov.lab3.controller.DepartmentCreator;
import ua.rudakov.lab3.controller.FacultyCreator;
import ua.rudakov.lab3.controller.GroupCreator;
import ua.rudakov.lab3.controller.HumanCreator;
import ua.rudakov.lab3.controller.StudentCreator;
import ua.rudakov.lab3.controller.UniversityCreator;
import ua.rudakov.lab3.model.AbstractUnit;
import ua.rudakov.lab3.model.University;

/**
 * Лабораторна робота №3. Точка входу: створення та виведення університету.
 */
public class Run {

    private static final String UNIVERSITY_NAME = "Державний технічний університет";
    private static final int FACULTIES = 2;
    private static final int DEPARTMENTS_PER_FACULTY = 2;
    private static final int GROUPS_PER_DEPARTMENT = 2;
    private static final int STUDENTS_PER_GROUP = 3;
    private static final String INDENT = "    ";

    public static void main(String[] args) {
        University university = createTypicalUniversity();
        printUnit(university, 0);
    }

    /**
     * Створює типовий університет: 2 факультети, на кожному 2 кафедри,
     * на кожній кафедрі 2 групи, у кожній групі 3 студенти.
     */
    public static University createTypicalUniversity() {
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator(humanCreator);
        GroupCreator groupCreator =
                new GroupCreator(studentCreator, humanCreator, STUDENTS_PER_GROUP);
        DepartmentCreator departmentCreator =
                new DepartmentCreator(groupCreator, humanCreator, GROUPS_PER_DEPARTMENT);
        FacultyCreator facultyCreator =
                new FacultyCreator(departmentCreator, humanCreator, DEPARTMENTS_PER_FACULTY);
        UniversityCreator universityCreator =
                new UniversityCreator(UNIVERSITY_NAME, facultyCreator, humanCreator, FACULTIES);
        return universityCreator.create();
    }

    /**
     * Рекурсивно виводить підрозділ і всі його вкладені підрозділи з відступами.
     */
    private static void printUnit(AbstractUnit<?> unit, int level) {
        System.out.println(INDENT.repeat(level) + unit);
        for (Object member : unit.getMembers()) {
            if (member instanceof AbstractUnit<?> subunit) {
                printUnit(subunit, level + 1);
            } else {
                System.out.println(INDENT.repeat(level + 1) + "- " + member);
            }
        }
    }
}
