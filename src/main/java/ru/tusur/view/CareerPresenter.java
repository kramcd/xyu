package ru.tusur.view;

import ru.tusur.domain.Career;

/**
 * Created by kramc_000 on 19.05.14.
 */
public class CareerPresenter {

    private Career career;

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
