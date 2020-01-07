package com.onlinetest.admin.servlet.user;

import com.onlinetest.admin.entity.Result;
import com.onlinetest.admin.entity.User;
import com.onlinetest.admin.service.LoginService;
import com.onlinetest.admin.service.impl.LoginServiceImpl;
import com.onlinetest.admin.utils.ResCode;
import com.onlinetest.admin.utils.ResUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author JasonWu
 * @create 2019-12-19-20:50
 */
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private final int COOKIE_TIME = 60;

    private LoginService loginService = new LoginServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Result result = null;
        //获取cookie
        Cookie[] cookies=request.getCookies();
        //获取参数用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //传递参数
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //进行数据库操作
        int res = loginService.login(user);
        //返回结果
        switch (res){
            case 0:
                System.out.println("用户不存在-"+user);
                //返回信息
                result = new Result(false, ResCode.NOPERMISS,"用户不存在，登录失败");
                ResUtil.toJson(result,response);
                //注销session与cookie
                session.invalidate();
                for(Cookie cookie: cookies){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                break;
            case -1:
                System.out.println("密码错误-"+user);
                //返回信息
                result = new Result(false, ResCode.NOPERMISS,"用户密码错误，登录失败");
                ResUtil.toJson(result,response);
                //注销session与cookie
                session.invalidate();
                for(Cookie cookie: cookies){
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
                break;
            case 1:
                System.out.println("登录成功-"+user);
                //设置cookie内容
                Cookie cookie1 = new Cookie("username", user.getUsername());
                Cookie cookie2 = new Cookie("s_id", session.getId());
                //设置cookie有效期
//                cookie1.setMaxAge(COOKIE_TIME);
//                cookie2.setMaxAge(COOKIE_TIME);
                //把cookie发送给浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                //返回信息
                String backUrl = "http://" + request.getServerName() + ":"
                        + request.getServerPort() + request.getContextPath()
                        + "/admin_page.html";
                result = new Result(true, ResCode.OPERATIONSUCCESS,"用户登录成功",backUrl);
                ResUtil.toJson(result,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
