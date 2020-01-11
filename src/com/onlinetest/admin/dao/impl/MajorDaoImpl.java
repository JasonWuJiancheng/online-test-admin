package com.onlinetest.admin.dao.impl;

import com.onlinetest.admin.dao.BaseDao;
import com.onlinetest.admin.dao.MajorDao;
import com.onlinetest.admin.entity.Major;
import com.onlinetest.admin.utils.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author JasonWu
 * @create 2020-01-11-1:13
 */
public class MajorDaoImpl extends BaseDao implements MajorDao {
    @Override
    public List<Major> selectAll() {
        String sql = "select * from sys_major";
        List<Major> majors = (List<Major>) executeQuery(new ResultSetProcessor() {

            @Override
            public Object process(ResultSet rs) throws SQLException {
                List<Major> list = new ArrayList<Major>();
                while (rs.next()) {
                    String majorId = rs.getString("major_id");
                    String name = rs.getString("name");
                    list.add(new Major(majorId,name));
                }
                return list;
            }
        }, sql);
        return majors;
    }

    @Override
    public Major selectByKeyWord() {
        return null;
    }

    @Override
    public String insert(Major major) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String sql = "insert into sys_major (major_id, name) values (?, ?)";
        executeUpdate(sql,uuid,major.getName());
        return uuid;
    }

    @Override
    public int deleteById(String majorId) {
        String sql = "delete from sys_major where major_id=?";
        return executeUpdate(sql, majorId);
    }

    @Override
    public int update(Major major) {
        String sql = "update sys_major set name=? where major_id=?";
        return executeUpdate(sql, major.getName(),major.getMajorId());
    }
}
