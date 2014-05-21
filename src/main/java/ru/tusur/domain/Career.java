package ru.tusur.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Career {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "EmployeesId")
    private Employees employees;

    @Column(name = "career_date")
    private LocalDate date;

    @Column(name = "career_comment")
    private String coment;

    @Enumerated(EnumType.STRING)
    @Column(name = "career_post")
    private Post post;

    public int getId() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
