package ru.tusur.view;

import ru.tusur.domain.Employees;

import java.io.IOException;

/**
 * Created by kramc_000 on 15.05.14.
 */
public class EmployeesPresenter {

    private Employees employees;

    private String id;

    private String bithDay;

    private String employeementDate;

    public EmployeesPresenter(Employees employees){
        this.employees = employees;
    }

    public EmployeesPresenter(){
        employees = new Employees();
    }

    public String getEmployeementDate() {
        return employeementDate;
    }

    public void setEmployeementDate(String employeementDate) {
        this.employeementDate = employeementDate;
    }

    public String getBithDay() {
        return bithDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
