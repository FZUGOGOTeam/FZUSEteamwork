package com.gogo.pojo;

public class GameData {
    private String name;
    private Integer id;
    private Integer season;
    private Integer playMatch;
    private Integer goals;
    private Integer assists;
    private Integer yellowCards;
    private Integer redCards;

    public GameData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getPlayMatch() {
        return playMatch;
    }

    public void setPlayMatch(Integer playMatch) {
        this.playMatch = playMatch;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    @Override
    public String toString() {
        return "GameData{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", season=" + season +
                ", playMatch=" + playMatch +
                ", goals=" + goals +
                ", assists=" + assists +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                '}';
    }
}
