package ru.tusur.view;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.tusur.domain.City;

/**
 * xyu
 * ru.tusur.view
 * by Oleg Alekseev
 * 15.04.14.
 */
public class CityPresenter {

    private boolean persisted;

    private City city;

    public CityPresenter() {
        city = new City();
    }

    public CityPresenter(City city){
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isPersisted() {
        return persisted;
    }

    public void setPersisted(boolean persisted) {
        this.persisted = persisted;
    }

}
