package ru.tusur.view;

import ru.tusur.domain.Employees;

/**
 * Created by kramc_000 on 15.05.14.
 */
public class EmployeesPresenter {

    private Employees employees;

    public EmployeesPresenter(Employees employees){
        this.employees = employees;
    }

    public EmployeesPresenter(){

    }


    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
