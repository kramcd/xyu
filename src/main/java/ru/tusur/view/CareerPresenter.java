package ru.tusur.view;

import ru.tusur.domain.Career;

public class CareerPresenter {

    private Career career;

    private String dDate;

    public String getdDate() {
        return dDate;
    }

    public void setdDate(String date) {
        this.dDate = date;
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
