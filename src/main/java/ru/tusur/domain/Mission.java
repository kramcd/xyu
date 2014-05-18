package ru.tusur.domain;

import javax.persistence.*;
import java.time.LocalDate;


@Entity

public class Mission {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private LocalDate dispatchDate;


    @Column(nullable = false)
    private LocalDate returnhDate;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private int money;

    @ManyToOne
    @JoinColumn(name = "idEmployees")
    private Employees employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public LocalDate getReturnhDate() {
        return returnhDate;
    }

    public void setReturnhDate(LocalDate returnhDate) {
        this.returnhDate = returnhDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}
