package ua.rudakov.lab5.dao;

import ua.rudakov.lab5.model.Student;

import java.time.Month;
import java.util.List;

/**
 * Доступ до даних про студентів.
 */
public interface StudentDao {

    /**
     * Повертає студентів, які народилися у вказаному місяці (будь-якого року).
     */
    List<Student> findByBirthMonth(Month month);
}
