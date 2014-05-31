package ru.tusur.domain;

/**
 * Created by kramc_000 on 15.05.14.
 */
public enum applicationType {

    Отпуск("Отпуск"),
    Больничный("Больничный"),
    Отгул("Отгул"),
    Учеба("Учеба");

    private String text;

    public String getText() {
        return text;
    }

    applicationType(String text) {
        this.text = text;
    }

}
