package com.onlinetest.admin;

import com.onlinetest.admin.entity.User;
import com.onlinetest.admin.service.LoginService;
import com.onlinetest.admin.service.impl.LoginServiceImpl;

/**
 * @author JasonWu
 * @create 2020-01-06-21:55
 */
public class Test {

    public static void main(String[] args) {
        LoginService loginService = new LoginServiceImpl();

        User user = new User();
        user.setUsername("2016110444");
        user.setPassword("1");
        int res = loginService.login(user);

        System.out.println("res="+res);
    }
}
