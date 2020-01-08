package com.onlinetest.admin.servlet.user;

import com.onlinetest.admin.entity.Result;
import com.onlinetest.admin.utils.ResCode;
import com.onlinetest.admin.utils.ResUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JasonWu
 * @create 2020-01-08-13:50
 */
@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //注销session与cookie
        Cookie[] cookies=req.getCookies();
        req.getSession().invalidate();
        for(Cookie cookie: cookies){
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }

        //返回信息
        String backUrl = "http://" + req.getServerName() + ":"
                + req.getServerPort() + req.getContextPath()
                + "/login.html";
        Result result = new Result(true, ResCode.OPERATIONSUCCESS, "用户登出成功", backUrl);
        ResUtil.toJson(result,resp);

    }
}
