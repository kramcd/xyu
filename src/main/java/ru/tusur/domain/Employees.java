package ru.tusur.domain;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Employees {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 100, nullable = false)
    private String famaly;

    @Column(length = 100, nullable = false)
    private String middleName;

    @Column(length = 100, nullable = false)
    private  String name;

    @Enumerated(EnumType.STRING)
    private Post post;

    @Column(nullable = false)
    private Date bithDay;

    @Column(length = 11, nullable = false)
    private String numberTel;

    @Column(length = 700, nullable = false)
    private String address;

    @Column(length = 10, nullable = false)
    private String Pasport;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public Date getBithDay() {
        return bithDay;
    }

    public void setBithDay(Date age) {
        this.bithDay = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamaly() {
        return famaly;
    }

    public void setFamaly(String famaly) {
        this.famaly = famaly;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getNumberTel() {
        return numberTel;
    }

    public void setNumberTel(String numberTel) {
        this.numberTel = numberTel;
    }

    public String getPasport() {
        return Pasport;
    }

    public void setPasport(String pasport) {
        Pasport = pasport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
