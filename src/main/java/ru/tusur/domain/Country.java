package ru.tusur.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity


public class Country {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 4, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    public Country(){}

    public Country(String code, String name){
        this.code = code;
        this.name = name;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
