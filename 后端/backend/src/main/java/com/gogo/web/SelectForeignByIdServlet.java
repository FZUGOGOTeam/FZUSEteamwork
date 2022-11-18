package com.gogo.web;

import com.alibaba.fastjson.JSON;
import com.gogo.pojo.DomesticPlayer;
import com.gogo.pojo.ForeignPlayer;
import com.gogo.service.DomesticPlayerService;
import com.gogo.service.ForeignPlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/selectForeignById")
public class SelectForeignByIdServlet extends HttpServlet {
    private final ForeignPlayerService foreignPlayerService = new ForeignPlayerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ForeignPlayer foreignPlayer = foreignPlayerService.selectById(Integer.parseInt(id));
        String jsonString = JSON.toJSONString(foreignPlayer);
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
