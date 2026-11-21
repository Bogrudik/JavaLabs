package ua.rudakov.lab5.view;

import ua.rudakov.lab5.model.Student;

import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

/**
 * Виведення інформації на екран (консоль).
 */
public class StudentView {

    private static final Locale UKRAINIAN = Locale.forLanguageTag("uk");
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final String ROW_FORMAT = "%-4s %-42s %-12s %-10s%n";

    public void showWelcome() {
        System.out.println("=== Пошук студентів за місяцем народження ===");
    }

    public void showPrompt() {
        System.out.println();
        System.out.print("Введіть номер місяця (1-12) або 0 для виходу: ");
    }

    public void showStudents(Month month, List<Student> students) {
        String monthName = month.getDisplayName(TextStyle.FULL_STANDALONE, UKRAINIAN);
        if (students.isEmpty()) {
            System.out.println("У місяці \"" + monthName + "\" не народився жоден студент.");
            return;
        }
        System.out.println("Студенти, які народилися в місяці \"" + monthName + "\" ("
                + students.size() + "):");
        System.out.printf(ROW_FORMAT, "ID", "ПІБ", "Народження", "Залікова");
        for (Student student : students) {
            System.out.printf(ROW_FORMAT, student.getId(), student.getFullName(),
                    student.getBirthDate().format(DATE_FORMAT), student.getRecordBookNumber());
        }
    }

    public void showError(String message) {
        System.out.println("Помилка: " + message);
    }

    public void showGoodbye() {
        System.out.println("Роботу програми завершено.");
    }
}
