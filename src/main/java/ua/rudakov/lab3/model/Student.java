package ua.rudakov.lab3.model;

/**
 * Студент - це людина, яка додатково має номер залікової книжки.
 */
public class Student extends Human {

    private String recordBookNumber;

    public Student(String firstName, String lastName, String patronymic, Sex sex,
                   String recordBookNumber) {
        super(firstName, lastName, patronymic, sex);
        this.recordBookNumber = recordBookNumber;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(String recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    @Override
    public String toString() {
        return getFullName() + ", залікова книжка № " + recordBookNumber;
    }
}
