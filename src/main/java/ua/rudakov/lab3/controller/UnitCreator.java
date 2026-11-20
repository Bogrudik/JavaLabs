package ua.rudakov.lab3.controller;

import ua.rudakov.lab3.model.AbstractUnit;
import ua.rudakov.lab3.model.Human;

/**
 * Базовий створювач підрозділів. Створює підрозділ, призначає йому голову
 * та заповнює його підрозділами нижчого рівня за допомогою створювача нижчого рівня.
 *
 * @param <U> тип підрозділу, який створюється
 * @param <M> тип підрозділів нижчого рівня
 */
public abstract class UnitCreator<U extends AbstractUnit<M>, M> implements Creator<U> {

    private final Creator<M> memberCreator;
    private final HumanCreator headCreator;
    private final int memberCount;
    private int createdCount;

    protected UnitCreator(Creator<M> memberCreator, HumanCreator headCreator, int memberCount) {
        this.memberCreator = memberCreator;
        this.headCreator = headCreator;
        this.memberCount = memberCount;
    }

    @Override
    public U create() {
        createdCount++;
        U unit = instantiate(generateName(createdCount), headCreator.create());
        for (int i = 0; i < memberCount; i++) {
            unit.addMember(memberCreator.create());
        }
        return unit;
    }

    /**
     * Повертає назву для підрозділу з порядковим номером number (нумерація з 1).
     */
    protected abstract String generateName(int number);

    /**
     * Створює порожній підрозділ із заданими назвою та головою.
     */
    protected abstract U instantiate(String name, Human head);

    /**
     * Обирає назву зі списку. Якщо назви закінчились, додає до назви номер.
     */
    protected static String nameFromPool(String[] pool, int number) {
        int index = (number - 1) % pool.length;
        int round = (number - 1) / pool.length;
        return round == 0 ? pool[index] : pool[index] + " " + (round + 1);
    }
}
