package ru.tusur.domain;

/**
 * xyu
 * ru.tusur
 * by Oleg Alekseev
 * 15.04.14.
 */
public class City {

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Code: %s, name: %s", code, name);
    }
}
