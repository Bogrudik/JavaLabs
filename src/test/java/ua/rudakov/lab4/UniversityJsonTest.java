package ua.rudakov.lab4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ua.rudakov.lab4.json.JsonManager;
import ua.rudakov.lab4.model.University;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Перевіряє, що університет після запису у файл JSON та зчитування з нього
 * залишається еквівалентним початковому.
 */
class UniversityJsonTest {

    private static final int UNITS_PER_LEVEL = 2;

    @Test
    void universityRestoredFromJsonFileEqualsOriginal(@TempDir Path tempDir) throws IOException {
        // на кожному рівні по два підрозділи нижчого рівня
        University oldUniversity = Run.createUniversity(
                UNITS_PER_LEVEL, UNITS_PER_LEVEL, UNITS_PER_LEVEL, UNITS_PER_LEVEL);
        JsonManager jsonManager = new JsonManager();
        Path file = tempDir.resolve("university.json");

        jsonManager.writeToFile(oldUniversity, file);
        assertTrue(Files.exists(file), "Файл JSON повинен бути створений");

        University newUniversity = jsonManager.readFromFile(file);

        assertNotSame(oldUniversity, newUniversity);
        assertTrue(oldUniversity.equals(newUniversity), "Університети повинні бути еквівалентні");
        assertEquals(oldUniversity, newUniversity);
    }
}
