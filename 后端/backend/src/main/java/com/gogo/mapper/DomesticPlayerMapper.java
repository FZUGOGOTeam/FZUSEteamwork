package com.gogo.mapper;

import com.gogo.pojo.DomesticPlayer;

import java.util.List;

public interface DomesticPlayerMapper {

    DomesticPlayer selectById(int id);

    List<DomesticPlayer> selectByPartName(String name);

    List<DomesticPlayer> selectByClub(String clubName);
    DomesticPlayer selectByName(String name);
}
