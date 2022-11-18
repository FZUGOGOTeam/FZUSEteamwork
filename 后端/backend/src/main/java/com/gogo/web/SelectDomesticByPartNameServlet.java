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
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/selectDomesticByPartName")
public class SelectDomesticByPartNameServlet extends HttpServlet {
    private final DomesticPlayerService domesticPlayerService = new DomesticPlayerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        name = "%" + name + "%";
        List<DomesticPlayer> domesticPlayers = domesticPlayerService.selectByPartName(name);
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(domesticPlayers);
        PrintWriter writer = resp.getWriter();
        writer.write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
