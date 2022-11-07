package com.gogo.mapper;

import com.gogo.pojo.DomesticPlayer;
import com.gogo.pojo.ForeignPlayer;

import java.util.List;

public interface ForeignPlayerMapper {

    ForeignPlayer selectById(int id);

    List<ForeignPlayer> selectByName(String name);
}
