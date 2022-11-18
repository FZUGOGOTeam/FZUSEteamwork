package com.gogo.mapper;

import com.gogo.pojo.GameData;

import java.util.List;

public interface GameDataMapper {
    List<GameData> selectById(int id);
    List<GameData> selectByName(String name);
}
