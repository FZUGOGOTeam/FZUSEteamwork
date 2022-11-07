package com.gogo.pojo;

import java.util.Date;

public class ForeignPlayer {
    private Integer id;
    private String name;
    private String nationality;
    private Integer number;
    private Date birthday;
    private String club;
    private Integer age;
    private String role;
    private Integer height;
    private Integer weight;
    private Double rating;
    private Double playingTime;
    private String region;

    public ForeignPlayer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(Double playingTime) {
        this.playingTime = playingTime;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "ForeignPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", number=" + number +
                ", birthday=" + birthday +
                ", club='" + club + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", rating=" + rating +
                ", playingTime=" + playingTime +
                ", region='" + region + '\'' +
                '}';
    }
}
