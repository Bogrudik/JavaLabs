package ua.rudakov.lab3.controller;

/**
 * Загальний інтерфейс усіх створювачів.
 *
 * @param <T> тип об'єкта, який створюється
 */
public interface Creator<T> {

    T create();
}
