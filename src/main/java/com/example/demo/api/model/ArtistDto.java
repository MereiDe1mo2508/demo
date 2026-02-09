package com.example.demo.api.model;
public class ArtistDto {
    //--Attributes--
    private Long id;
    private String name;
    private int age;
    private Long artwork_id;

    //--Constructors--
    public ArtistDto(Long id, String name, int age, Long artwork_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.artwork_id = artwork_id;
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
    public Long getArtwork_id() {
        return artwork_id;
    }
    public void setArtwork_id(Long artwork_id) {
        this.artwork_id = artwork_id;
    }
}