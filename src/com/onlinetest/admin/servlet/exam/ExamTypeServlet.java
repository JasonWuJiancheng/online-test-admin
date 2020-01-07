package com.onlinetest.admin.servlet.exam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author JasonWu
 * @create 2020-01-07-16:41
 */
@WebServlet(value = "/examtype")
public class ExamTypeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String method = req.getParameter("method");

        if(method=="" || method==null){

        }

    }
}
