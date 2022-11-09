package com.gogo.mapper;

import com.gogo.pojo.DomesticPlayer;

import java.util.List;

public interface DomesticPlayerMapper {

    DomesticPlayer selectById(int id);

    List<DomesticPlayer> selectByName(String name);

    List<DomesticPlayer> selectAll();
}
