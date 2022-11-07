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

@WebServlet("/selectDomesticById")
public class SelectDomesticByIdServlet extends HttpServlet {
    private final DomesticPlayerService domesticPlayerService = new DomesticPlayerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DomesticPlayer domesticPlayer = domesticPlayerService.selectById(Integer.parseInt(id));
        String jsonString = JSON.toJSONString(domesticPlayer);
        PrintWriter writer = resp.getWriter();
        writer.write(jsonString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
