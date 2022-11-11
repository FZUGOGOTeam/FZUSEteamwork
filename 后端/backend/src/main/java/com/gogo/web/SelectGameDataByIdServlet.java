package com.gogo.web;

import com.alibaba.fastjson.JSON;
import com.gogo.pojo.GameData;
import com.gogo.service.GameDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/selectGameDataById")
public class SelectGameDataByIdServlet extends HttpServlet {
    private final GameDataService gameDataService = new GameDataService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<GameData> gameData = gameDataService.selectById(Integer.parseInt(id));
        String jsonString = JSON.toJSONString(gameData);
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
