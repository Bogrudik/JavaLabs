package ua.rudakov.lab5;

import ua.rudakov.lab5.controller.StudentController;
import ua.rudakov.lab5.dao.JdbcStudentDao;
import ua.rudakov.lab5.db.ConnectionFactory;
import ua.rudakov.lab5.view.StudentView;

import java.util.Scanner;

/**
 * Лабораторна робота №5. Виведення студентів, які народилися в заданому місяці.
 */
public class Run {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController controller = new StudentController(
                new JdbcStudentDao(new ConnectionFactory()), new StudentView(), scanner);
        controller.run();
    }
}
