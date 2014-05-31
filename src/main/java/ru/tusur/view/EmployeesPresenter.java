package ru.tusur.view;

import ru.tusur.domain.Employees;

import java.io.IOException;

/**
 * Created by kramc_000 on 15.05.14.
 */
public class EmployeesPresenter {

    private Employees employees;

    private String bithDay;

    public EmployeesPresenter(Employees employees){
        this.employees = employees;
    }

    public EmployeesPresenter(){
        employees = new Employees();
    }

    public String getBithDay() {
        return bithDay;
    }

    public void setBithDay(String bithDay) {
        this.bithDay = bithDay;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }


}
