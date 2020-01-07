package com.onlinetest.admin.dao;

import com.onlinetest.admin.entity.User;

/**
 * @author JasonWu
 * @create 2019-12-19-19:23
 */
public interface UserDao {

    User findUserByUsername(String userName);

    int countUserByUsername(String userName);

    int insertUser(User user);

}
