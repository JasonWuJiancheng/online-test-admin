package com.onlinetest.admin.dao.impl;

import com.onlinetest.admin.dao.BaseDao;
import com.onlinetest.admin.dao.GradeDao;
import com.onlinetest.admin.entity.Grade;
import com.onlinetest.admin.utils.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author JasonWu
 * @create 2020-01-10-21:43
 */
public class GradeDaoImpl extends BaseDao implements GradeDao {

    @Override
    public List<Grade> selectAll() {
        String sql = "select * from sys_grade";
        List<Grade> grades = (List<Grade>) executeQuery(new ResultSetProcessor() {

            @Override
            public Object process(ResultSet rs) throws SQLException {
                List<Grade> list = new ArrayList<Grade>();
                while (rs.next()) {
                    String gradeId = rs.getString("grade_id");
                    String name = rs.getString("name");
                    list.add(new Grade(gradeId,name));
                }
                return list;
            }
        }, sql);
        return grades;
    }

    @Override
    public Grade selectByKeyWord() {
        return null;
    }

    @Override
    public String insert(Grade grade) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String sql = "insert into sys_grade (grade_id, name) values (?, ?)";
        executeUpdate(sql,uuid,grade.getName());
        return uuid;
    }

    @Override
    public int deleteById(String gradeId) {
        String sql = "delete from sys_grade where grade_id=?";
        return executeUpdate(sql, gradeId);
    }

    @Override
    public int update(Grade grade) {
        String sql = "update sys_grade set name=? where grade_id=?";
        return executeUpdate(sql, grade.getName(),grade.getGradeId());
    }
}
