package ru.tusur.view;

import ru.tusur.domain.Person;

/**
 * Created by kramc_000 on 18.04.14.
 */
public class PersonPresenter {

    private boolean persisted;

    private boolean adult;

    private Person person;

    public PersonPresenter() {
        person = new Person();
    }

    public PersonPresenter(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isPersisted() {
        return persisted;
    }

    public void setPersisted(boolean persisted) {
        this.persisted = persisted;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}
