package com.gogo.pojo;

public class GameData {
    private String name;
    private String season;
    private String playCount;
    private String goal;
    private String assists;
    private String yellowCards;
    private String redCards;
    private String starterCount;
    private String clubName;

    public GameData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
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

    public String getStarterCount() {
        return starterCount;
    }

    public void setStarterCount(String starterCount) {
        this.starterCount = starterCount;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    @Override
    public String toString() {
        return "GameData{" +
                "name='" + name + '\'' +
                ", season='" + season + '\'' +
                ", playCount='" + playCount + '\'' +
                ", goal='" + goal + '\'' +
                ", assists='" + assists + '\'' +
                ", yellowCards='" + yellowCards + '\'' +
                ", redCards='" + redCards + '\'' +
                ", starterCount='" + starterCount + '\'' +
                ", clubName='" + clubName + '\'' +
                '}';
    }
}
