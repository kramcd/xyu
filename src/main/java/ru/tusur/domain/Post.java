package ru.tusur.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




public enum  Post {

   sdRfsdf ("Отпуск"), HOSPITAL("Больничный"),HOLIDAYSHORT("Отгул"), STUSYLEAVE("Учеба"), DEAD("Сдох к хуям");

    private String text;

    public String getText() {
        return text;
    }

    Post(String text){
        this.text = text;
    }
}
