package ua.rudakov.lab4.controller;

import ua.rudakov.lab4.model.Human;
import ua.rudakov.lab4.model.Sex;

import java.util.Random;

/**
 * Створює людей з випадковими ПІБ та статтю.
 */
public class HumanCreator implements Creator<Human> {

    private static final String[] MALE_NAMES = {
        "Богдан", "Олександр", "Дмитро", "Андрій", "Максим",
        "Іван", "Тарас", "Назар", "Ярослав", "Віталій"
    };
    private static final String[] FEMALE_NAMES = {
        "Олена", "Марія", "Анастасія", "Ірина", "Софія",
        "Дарина", "Катерина", "Юлія", "Вікторія", "Оксана"
    };
    private static final String[] LAST_NAMES = {
        "Коваленко", "Бондаренко", "Ткачук", "Кравчук", "Шевчук", "Олійник", "Мельник", "Савченко",
        "Гаврилюк", "Лисенко", "Руденко", "Пономаренко", "Головко", "Зінченко", "Марченко", "Кучер"
    };
    /** Імена батьків: по батькові для чоловіка та для жінки. */
    private static final String[][] PATRONYMICS = {
        {"Олександрович", "Олександрівна"},
        {"Петрович", "Петрівна"},
        {"Іванович", "Іванівна"},
        {"Сергійович", "Сергіївна"},
        {"Миколайович", "Миколаївна"},
        {"Володимирович", "Володимирівна"},
        {"Юрійович", "Юріївна"}
    };

    private final Random random = new Random();

    @Override
    public Human create() {
        Sex sex = randomSex();
        return new Human(randomFirstName(sex), randomLastName(), randomPatronymic(sex), sex);
    }

    protected Sex randomSex() {
        return random.nextBoolean() ? Sex.MALE : Sex.FEMALE;
    }

    protected String randomFirstName(Sex sex) {
        return sex == Sex.MALE ? randomElement(MALE_NAMES) : randomElement(FEMALE_NAMES);
    }

    protected String randomLastName() {
        return randomElement(LAST_NAMES);
    }

    protected String randomPatronymic(Sex sex) {
        String[] forms = PATRONYMICS[random.nextInt(PATRONYMICS.length)];
        return sex == Sex.MALE ? forms[0] : forms[1];
    }

    private String randomElement(String[] array) {
        return array[random.nextInt(array.length)];
    }
}
