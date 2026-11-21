package ua.rudakov.lab5.controller;

import ua.rudakov.lab5.dao.StudentDao;
import ua.rudakov.lab5.db.DataAccessException;
import ua.rudakov.lab5.model.Student;
import ua.rudakov.lab5.view.StudentView;

import java.time.Month;
import java.util.List;
import java.util.Scanner;

/**
 * Контролер: зчитує запит користувача, отримує дані через DAO та передає їх у вид.
 */
public class StudentController {

    private static final int EXIT_COMMAND = 0;

    private final StudentDao studentDao;
    private final StudentView view;
    private final Scanner scanner;

    public StudentController(StudentDao studentDao, StudentView view, Scanner scanner) {
        this.studentDao = studentDao;
        this.view = view;
        this.scanner = scanner;
    }

    public void run() {
        view.showWelcome();
        while (true) {
            view.showPrompt();
            if (!scanner.hasNext()) {
                break;
            }
            String input = scanner.next();
            int command;
            try {
                command = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                view.showError("'" + input + "' не є числом.");
                continue;
            }
            if (command == EXIT_COMMAND) {
                break;
            }
            if (command < 1 || command > 12) {
                view.showError("номер місяця повинен бути від 1 до 12.");
                continue;
            }
            showStudentsBornIn(Month.of(command));
        }
        view.showGoodbye();
    }

    private void showStudentsBornIn(Month month) {
        try {
            List<Student> students = studentDao.findByBirthMonth(month);
            view.showStudents(month, students);
        } catch (DataAccessException e) {
            view.showError(e.getMessage());
        }
    }
}
