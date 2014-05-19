package ru.tusur.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Career {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Post post;

    @Column(nullable = false)
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
