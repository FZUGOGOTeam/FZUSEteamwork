package com.gogo.service;

import com.gogo.mapper.DomesticPlayerMapper;
import com.gogo.mapper.ForeignPlayerMapper;
import com.gogo.pojo.DomesticPlayer;
import com.gogo.pojo.ForeignPlayer;
import com.gogo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ForeignPlayerService {
    public ForeignPlayer selectById(int id) {
        //
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        ForeignPlayerMapper mapper = sqlSession.getMapper(ForeignPlayerMapper.class);
        ForeignPlayer foreignPlayer = mapper.selectById(id);
        sqlSession.close();
        return foreignPlayer;
    }

    public List<ForeignPlayer> selectByName(String name) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        ForeignPlayerMapper mapper = sqlSession.getMapper(ForeignPlayerMapper.class);
        List<ForeignPlayer> foreignPlayers = mapper.selectByName(name);
        return foreignPlayers;
    }
}
