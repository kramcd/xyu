package ru.tusur.view;

import ru.tusur.domain.Career;

public class CareerPresenter {

    private Career career;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CareerPresenter(Career career) {
        this.career = career;
    }

    public CareerPresenter(){
        career = new Career();
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }
}
