package com.onlinetest.admin.dao.impl;

import com.onlinetest.admin.dao.BaseDao;
import com.onlinetest.admin.dao.UserDao;
import com.onlinetest.admin.entity.User;
import com.onlinetest.admin.utils.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author JasonWu
 * @create 2019-12-19-19:28
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User findUserByUsername(String userName) {
        String sql = "select * from sys_user where username = ?";
        User user = (User)executeQuery(new ResultSetProcessor() {

            @Override
            public Object process(ResultSet rs) throws SQLException {
                if(rs.next()) {
                    String userId = rs.getString("USER_ID");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("ROLE_ID");
                    return new User(userId,username, password, role);
                } else {
                    return null;
                }
            }
        }, sql, userName);
        return user;
    }

    @Override
    public int countUserByUsername(String userName) {
        String sql = "select count(1) user_count from sys_user where username = ?";
        int user_count = (Integer)executeQuery(new ResultSetProcessor() {

            @Override
            public Object process(ResultSet rs) throws SQLException {
                if(rs.next()){
                    int count = rs.getInt("user_count");
                    return new Integer(count);
                }else {
                    return 0;
                }
            }
        }, sql, userName);
        return user_count;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into sys_user (user_id, username, password, role_id) values (replace(uuid(), '-', ''), ?, ?, ?)";
        return executeUpdate(sql, user.getUsername(), user.getPassword(),user.getRole());
    }
}
