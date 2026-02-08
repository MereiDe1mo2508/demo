package com.example.demo.api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //--Attributes--
    private Long id;
    private String name;
    private int age;
    private boolean isAlive;

    //--Constructors--
    public Artist(Long id, String name, int age, boolean isAlive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isAlive = isAlive;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean getIsAlive() {
        return isAlive;
    }
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}