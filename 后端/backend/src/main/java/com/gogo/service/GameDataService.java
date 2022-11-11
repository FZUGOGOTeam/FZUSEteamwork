package com.gogo.service;

import com.gogo.mapper.GameDataMapper;
import com.gogo.pojo.GameData;
import com.gogo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GameDataService {
    public List<GameData> selectById(int id) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        GameDataMapper mapper = sqlSession.getMapper(GameDataMapper.class);
        List<GameData> gameData = mapper.selectById(id);
        sqlSession.close();
        return gameData;
    }
}
