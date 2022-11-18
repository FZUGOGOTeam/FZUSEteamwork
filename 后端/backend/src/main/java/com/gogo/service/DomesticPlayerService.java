package com.gogo.service;

import com.gogo.mapper.DomesticPlayerMapper;
import com.gogo.pojo.DomesticPlayer;
import com.gogo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DomesticPlayerService {
    public DomesticPlayer selectById(int id) {
        //
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DomesticPlayerMapper mapper = sqlSession.getMapper(DomesticPlayerMapper.class);
        DomesticPlayer domesticPlayer = mapper.selectById(id);
        sqlSession.close();
        return domesticPlayer;
    }

    public List<DomesticPlayer> selectByPartName(String name) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DomesticPlayerMapper mapper = sqlSession.getMapper(DomesticPlayerMapper.class);
        List<DomesticPlayer> domesticPlayers = mapper.selectByPartName(name);
        sqlSession.close();
        return domesticPlayers;
    }

    public List<DomesticPlayer> selectByClub(String clubName) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DomesticPlayerMapper mapper = sqlSession.getMapper(DomesticPlayerMapper.class);
        List<DomesticPlayer> domesticPlayers = mapper.selectByClub(clubName);
        sqlSession.close();
        return domesticPlayers;
    }

    public DomesticPlayer selectByName(String name) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DomesticPlayerMapper mapper = sqlSession.getMapper(DomesticPlayerMapper.class);
        DomesticPlayer domesticPlayer = mapper.selectByName(name);
        return domesticPlayer;
    }
}
