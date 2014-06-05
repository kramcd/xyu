package ru.tusur.domain;

/**
 * Created by kramc_000 on 05.06.14.
 */
public enum Gender {
    Мужской("Мужской"),
    Женский("Женский");

    private String text;

    public String getText() {
        return text;
    }

    Gender(String text){
        this.text = text;
    }
}
