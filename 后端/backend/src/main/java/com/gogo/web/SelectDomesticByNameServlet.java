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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/selectDomesticByName")
public class SelectDomesticByNameServlet extends HttpServlet {
    private final DomesticPlayerService domesticPlayerService = new DomesticPlayerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        name = "%" + name + "%";
        List<DomesticPlayer> domesticPlayers = domesticPlayerService.selectByName(name);
        for (int i = 0; i < domesticPlayers.size(); i++) {
            DomesticPlayer domesticPlayer = domesticPlayers.get(i);
            String jsonString = JSON.toJSONString(domesticPlayer);
            PrintWriter writer = resp.getWriter();
            writer.write(jsonString);
            writer.flush();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
