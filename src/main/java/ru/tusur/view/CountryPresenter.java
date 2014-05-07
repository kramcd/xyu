package ru.tusur.view;

import ru.tusur.domain.Country;

/**
 * Created by kramc_000 on 26.04.14.
 */
public class CountryPresenter {

    private Country country;

    public CountryPresenter(){
        country = new Country();
    }

    public CountryPresenter(Country country){
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
