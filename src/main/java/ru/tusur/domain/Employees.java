package ru.tusur.domain;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Employees {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String famaly;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false)
    private  String name;

    @Enumerated(EnumType.STRING)
    private Post post;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private Date bithDay;

    @Column(nullable = false)
    private Date employeementDate;

    @Column(nullable = false)
    private String numberTel;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String Pasport;

    @Column(nullable = false)
    private String numberPFR;

    @Enumerated(EnumType.STRING)
    private Role role;

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

    public Date getEmployeementDate() {
        return employeementDate;
    }

    public void setEmployeementDate(Date employeementDate) {
        this.employeementDate = employeementDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberPFR() {
        return numberPFR;
    }

    public void setNumberPFR(String numberPFR) {
        this.numberPFR = numberPFR;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
