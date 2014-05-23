package ru.tusur.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.sql.Date;

@Entity
public class Career {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Employees employees;

    @Column(name = "career_date")
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
