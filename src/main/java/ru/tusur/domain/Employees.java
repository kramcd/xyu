package ru.tusur.domain;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Employees {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 30, nullable = false)
    private String famaly;

    @Column(length = 30, nullable = false)
    private String middleName;

    @Column(length = 30, nullable = false)
    private  String name;

    @Enumerated(EnumType.STRING)
    private Post post;

    @Column(length = 11, nullable = false)
    private int numberTel;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 10, nullable = false)
    private int Pasport;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    private String code;

    public String getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFamaly() {
        return famaly;
    }

    public void setFamaly(String famaly) {
        this.famaly = famaly;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getNumberTel() {
        return numberTel;
    }

    public void setNumberTel(int numberTel) {
        this.numberTel = numberTel;
    }

    public int getPasport() {
        return Pasport;
    }

    public void setPasport(int pasport) {
        Pasport = pasport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
