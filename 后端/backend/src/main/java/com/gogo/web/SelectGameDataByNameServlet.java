package com.gogo.web;

import com.alibaba.fastjson.JSON;
import com.gogo.pojo.GameData;
import com.gogo.service.DomesticPlayerService;
import com.gogo.service.GameDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/selectGameDataByName")
public class SelectGameDataByNameServlet extends HttpServlet {
    private final GameDataService gameDataService = new GameDataService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        GameData gameData = gameDataService.selectByName(name);
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(gameData);
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
