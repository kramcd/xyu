package ru.tusur.domain;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Statement {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private applicationType applicationType;

    @Enumerated(EnumType.STRING)
    private applicationStatus applicationStatus;

    @ManyToOne
    @JoinColumn(name = "idEmployees")
    private Employees employees;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public applicationType getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(applicationType applicationType) {
        this.applicationType = applicationType;
    }

    public applicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(applicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
