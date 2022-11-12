package com.gogo.web;

import com.alibaba.fastjson.JSON;
import com.gogo.pojo.DomesticPlayer;
import com.gogo.service.DomesticPlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectDomesticByClub")
public class SelectDomesticByClubServlet extends HttpServlet {
    private final DomesticPlayerService domesticPlayerService = new DomesticPlayerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clubName = req.getParameter("clubName");
        List<DomesticPlayer> domesticPlayers = domesticPlayerService.selectByClub(clubName);
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(domesticPlayers);
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
