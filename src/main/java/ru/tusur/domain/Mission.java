package ru.tusur.domain;

import javax.persistence.*;
import java.sql.Date;


@Entity

public class Mission {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private Date dispatchDate;


    @Column(nullable = false)
    private Date returnDate;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private int money;

    @ManyToOne
    private Employees employees;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Date getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(Date dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
