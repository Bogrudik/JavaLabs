package ua.rudakov.lab3.controller;

import ua.rudakov.lab3.model.Human;
import ua.rudakov.lab3.model.Student;

/**
 * Створює студентів. Для отримання ПІБ та статі використовує {@link HumanCreator},
 * а номер залікової книжки генерує сам.
 */
public class StudentCreator implements Creator<Student> {

    private static final String RECORD_BOOK_PREFIX = "ЗК-";

    private final HumanCreator humanCreator;
    private int studentCounter;

    public StudentCreator(HumanCreator humanCreator) {
        this.humanCreator = humanCreator;
    }

    @Override
    public Student create() {
        Human human = humanCreator.create();
        studentCounter++;
        String recordBookNumber = RECORD_BOOK_PREFIX + String.format("%05d", studentCounter);
        return new Student(human.getFirstName(), human.getLastName(), human.getPatronymic(),
                human.getSex(), recordBookNumber);
    }
}
