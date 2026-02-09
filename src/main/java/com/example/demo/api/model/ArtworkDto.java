package com.example.demo.api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ArtworkDto {
    //--Attributes--
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private int date;
    private boolean copyrighted;
    private int price;

    //--Constructors
    public ArtworkDto(Long id, String title, String artist, int date, boolean copyrighted, int price) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.date = date;
        this.copyrighted = copyrighted;
        this.price = price;
    }

    //--Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public boolean getCopyrighted() {
        return copyrighted;
    }
    public void setCopyrighted(boolean copyrighted) {
        this.copyrighted = copyrighted;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    //--Methods--
    public void printInfo() {
        String status;
        if (copyrighted) {
            status = "Copyrighted";
            System.out.println("Title: " + title + "\nArtist: " + artist + "\nCreated: " + date + "\nStatus: " + status + "\nPrice: " + price);
        } else {
            status = "Not copyrighted";
            System.out.println("Title: " + title + "\nArtist: " + artist + "\nCreated: " + date + "\nStatus: " + status + "\nPrice: " + price);
        }
    }
}