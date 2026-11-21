package ua.rudakov.lab4.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.rudakov.lab4.model.University;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Перетворює університет у формат JSON і назад, записує JSON у файл та зчитує його з файлу.
 * Для перетворення використовується бібліотека Gson.
 */
public class JsonManager {

    private final Gson gson;

    public JsonManager() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();
    }

    /**
     * Перетворює університет у рядок формату JSON.
     */
    public String toJson(University university) {
        return gson.toJson(university);
    }

    /**
     * Створює об'єкт університету з рядка формату JSON.
     */
    public University fromJson(String json) {
        return gson.fromJson(json, University.class);
    }

    /**
     * Записує університет у файл у форматі JSON.
     */
    public void writeToFile(University university, Path file) throws IOException {
        Files.writeString(file, toJson(university), StandardCharsets.UTF_8);
    }

    /**
     * Зчитує файл у форматі JSON та відновлює з нього університет.
     */
    public University readFromFile(Path file) throws IOException {
        return fromJson(Files.readString(file, StandardCharsets.UTF_8));
    }
}
