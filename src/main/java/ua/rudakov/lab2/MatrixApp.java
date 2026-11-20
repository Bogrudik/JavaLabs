package ua.rudakov.lab2;

import java.util.Random;
import java.util.Scanner;

/**
 * Лабораторна робота №2. Створення матриці цілих чисел з клавіатури або
 * випадковим чином, пошук мінімального та максимального елементів,
 * обчислення середнього арифметичного та середнього геометричного.
 */
public class MatrixApp {

    /** Максимальна кількість рядків матриці. */
    private static final int MAX_ROWS = 20;
    /** Максимальна кількість стовпців матриці. */
    private static final int MAX_COLUMNS = 20;

    /** Нижня межа діапазону випадкових чисел (включно). */
    private static final int RANDOM_LOWER_BOUND = 10;
    /** Верхня межа діапазону випадкових чисел (включно). */
    private static final int RANDOM_UPPER_BOUND = 99;

    private static final int KEYBOARD_INPUT = 1;
    private static final int RANDOM_INPUT = 2;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.println("=== Робота з матрицею цілих чисел ===");
        int rows = readIntInRange(
                "Введіть висоту матриці (1.." + MAX_ROWS + "): ", 1, MAX_ROWS);
        int columns = readIntInRange(
                "Введіть ширину матриці (1.." + MAX_COLUMNS + "): ", 1, MAX_COLUMNS);

        int[][] matrix = createMatrix(rows, columns);

        System.out.println();
        System.out.println("Матриця " + rows + " x " + columns + ":");
        printMatrix(matrix);
        printStatistics(matrix);
    }

    /**
     * Запитує у користувача спосіб заповнення та створює матрицю.
     */
    private static int[][] createMatrix(int rows, int columns) {
        System.out.println("Оберіть спосіб заповнення матриці:");
        System.out.println("  " + KEYBOARD_INPUT + " - ввести елементи з клавіатури");
        System.out.println("  " + RANDOM_INPUT + " - заповнити випадковими числами від "
                + RANDOM_LOWER_BOUND + " до " + RANDOM_UPPER_BOUND);
        int choice = readIntInRange("Ваш вибір: ", KEYBOARD_INPUT, RANDOM_INPUT);

        if (choice == KEYBOARD_INPUT) {
            return fillFromKeyboard(rows, columns);
        }
        return fillRandomly(rows, columns);
    }

    private static int[][] fillFromKeyboard(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = readInt("a[" + (i + 1) + "][" + (j + 1) + "] = ");
            }
        }
        return matrix;
    }

    private static int[][] fillRandomly(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = RANDOM.nextInt(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND + 1);
            }
        }
        return matrix;
    }

    /**
     * Зчитує ціле число, повторюючи запит, доки користувач не введе коректне значення.
     */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (SCANNER.hasNextInt()) {
                return SCANNER.nextInt();
            }
            String wrongInput = SCANNER.next();
            System.out.println("Помилка: '" + wrongInput + "' не є цілим числом. Повторіть ввід.");
        }
    }

    /**
     * Зчитує ціле число з діапазону [min; max].
     */
    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Помилка: число повинно бути від " + min + " до " + max + ".");
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                min = Math.min(min, value);
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                max = Math.max(max, value);
            }
        }
        return max;
    }

    private static double arithmeticMean(int[][] matrix) {
        long sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }

    /**
     * Обчислює середнє геометричне елементів матриці.
     * Добуток до 400 чисел швидко виходить за межі double, тому
     * використовується формула через логарифми: G = exp((ln a1 + ... + ln an) / n).
     *
     * @return середнє геометричне або {@link Double#NaN}, якщо в матриці є від'ємні числа
     */
    private static double geometricMean(int[][] matrix) {
        double logSum = 0;
        int count = 0;
        boolean hasZero = false;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < 0) {
                    return Double.NaN;
                }
                if (value == 0) {
                    hasZero = true;
                } else {
                    logSum += Math.log(value);
                }
                count++;
            }
        }
        if (hasZero) {
            return 0;
        }
        return Math.exp(logSum / count);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%7d", value);
            }
            System.out.println();
        }
    }

    private static void printStatistics(int[][] matrix) {
        System.out.println();
        System.out.println("Мінімальний елемент: " + findMin(matrix));
        System.out.println("Максимальний елемент: " + findMax(matrix));
        System.out.printf("Середнє арифметичне: %.2f%n", arithmeticMean(matrix));

        double geometricMean = geometricMean(matrix);
        if (Double.isNaN(geometricMean)) {
            System.out.println("Середнє геометричне: не визначене (у матриці є від'ємні елементи)");
        } else {
            System.out.printf("Середнє геометричне: %.2f%n", geometricMean);
        }
    }
}
