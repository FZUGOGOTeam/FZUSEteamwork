package com.gogo.pojo;

import java.sql.Blob;
import java.util.Date;
public class DomesticPlayer {
    private Integer id;
    private String name;
    private String clubName;
    private Integer number;
    private Date birthday;
    private String preferredFoot;
    private Integer age;
    private Integer height;
    private Integer weight;
    private String position;
    private Integer score;

    public DomesticPlayer() {
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

    public String getPreferredFoot() {
        return preferredFoot;
    }

    public void setPreferredFoot(String preferredFoot) {
        this.preferredFoot = preferredFoot;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "DomesticPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clubName='" + clubName + '\'' +
                ", number=" + number +
                ", birthday=" + birthday +
                ", preferredFoot='" + preferredFoot + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", position=" + position +
                ", score=" + score +
                '}';
    }
}
