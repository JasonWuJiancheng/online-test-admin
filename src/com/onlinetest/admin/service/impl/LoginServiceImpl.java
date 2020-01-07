package com.onlinetest.admin.service.impl;

import com.onlinetest.admin.dao.UserDao;
import com.onlinetest.admin.dao.impl.UserDaoImpl;
import com.onlinetest.admin.entity.User;
import com.onlinetest.admin.service.LoginService;

/**
 * @author JasonWu
 * @create 2019-12-19-20:32
 */
public class LoginServiceImpl implements LoginService {

    //按需实例化DAO对象
    private UserDao userDao = new UserDaoImpl();

    /**
     * @description: 用户登录功能
     * @return returnNum（1：成功、-1：密码错误、0：用户不存在）
     */
    @Override
    public int login(User user) {
        int returnNum = 0;
        int count = userDao.countUserByUsername(user.getUsername());
        if(count>0){
            User u = userDao.findUserByUsername(user.getUsername());
            if(u == null){
                returnNum = 0;
            }else {
                if(user.getPassword().equals(u.getPassword())){
                    returnNum = 1;
                }else {
                    returnNum = -1;
                }
            }
        }else {
            returnNum = 0;
        }
        return returnNum;
    }
}
