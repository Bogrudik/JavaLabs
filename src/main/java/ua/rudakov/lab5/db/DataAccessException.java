package ua.rudakov.lab5.db;

/**
 * Виняток, що виникає при помилці роботи з базою даних.
 */
public class DataAccessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
