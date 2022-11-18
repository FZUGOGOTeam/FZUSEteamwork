package com.gogo.pojo;

public class GameData {
    private String name;
    private Integer id;
    private String season;
    private String playMatch;
    private String goals;
    private String assists;
    private String yellowCards;
    private String redCards;

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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getPlayMatch() {
        return playMatch;
    }

    public void setPlayMatch(String playMatch) {
        this.playMatch = playMatch;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(String yellowCards) {
        this.yellowCards = yellowCards;
    }

    public String getRedCards() {
        return redCards;
    }

    public void setRedCards(String redCards) {
        this.redCards = redCards;
    }

    @Override
    public String toString() {
        return "GameData{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", season='" + season + '\'' +
                ", playMatch='" + playMatch + '\'' +
                ", goals='" + goals + '\'' +
                ", assists='" + assists + '\'' +
                ", yellowCards='" + yellowCards + '\'' +
                ", redCards='" + redCards + '\'' +
                '}';
    }
}
