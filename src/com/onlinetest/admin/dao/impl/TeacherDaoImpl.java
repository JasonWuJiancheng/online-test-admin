package com.onlinetest.admin.dao.impl;

import com.onlinetest.admin.dao.BaseDao;
import com.onlinetest.admin.dao.TeacherDao;
import com.onlinetest.admin.entity.Teacher;
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
public class TeacherDaoImpl extends BaseDao implements TeacherDao {
    @Override
    public List<Teacher> selectAll() {
        String sql = "select * from sys_teacher";
        List<Teacher> teachers = (List<Teacher>) executeQuery(new ResultSetProcessor() {
            @Override
            public Object process(ResultSet rs) throws SQLException {
                List<Teacher> list = new ArrayList<Teacher>();
                while (rs.next()) {
                    String teacherId = rs.getString("teacher_id");
                    String name = rs.getString("name");
                    list.add(new Teacher(teacherId,name));
                }
                return list;
            }
        }, sql);
        return teachers;
    }

    @Override
    public Teacher selectByKeyWord() {
        return null;
    }

    @Override
    public String insert(Teacher teacher) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String sql = "insert into sys_teacher (teacher_id, name) values (?, ?)";
        executeUpdate(sql,uuid,teacher.getName());
        return uuid;
    }

    @Override
    public int deleteById(String teacherId) {
        String sql = "delete from sys_teacher where teacher_id=?";
        return executeUpdate(sql, teacherId);
    }

    @Override
    public int update(Teacher teacher) {
        String sql = "update sys_teacher set name=? where teacher_id=?";
        return executeUpdate(sql, teacher.getName(),teacher.getTeacherId());
    }
}
