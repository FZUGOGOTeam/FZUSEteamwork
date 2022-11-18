package com.gogo.pojo;

import java.sql.Blob;
import java.util.Date;
public class DomesticPlayer {
    private Integer id;
    private String name;
    private String clubName;
    private String number;
    private String birthday;
    private String preferredFoot;
    private String age;
    private String height;
    private String weight;
    private String position;
    private Integer score;
    private String photo;
    private String country;

    public DomesticPlayer() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPreferredFoot() {
        return preferredFoot;
    }

    public void setPreferredFoot(String preferredFoot) {
        this.preferredFoot = preferredFoot;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "DomesticPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clubName='" + clubName + '\'' +
                ", number='" + number + '\'' +
                ", birthday='" + birthday + '\'' +
                ", preferredFoot='" + preferredFoot + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", position='" + position + '\'' +
                ", score=" + score +
                ", photo='" + photo + '\'' +
                '}';
    }
}
