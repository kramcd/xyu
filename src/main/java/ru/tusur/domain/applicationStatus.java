package ru.tusur.domain;



/**
 * Created by kramc_000 on 15.05.14.
 */
public  enum applicationStatus {

    NEW("Новая"), ASSIGNED("Принята"), REJECTED("Отклонена"), CANCEL("Отменена");

    private String text;

    public String getText() {
        return text;
    }


    applicationStatus(String text){
        this.text = text;
    }
}
