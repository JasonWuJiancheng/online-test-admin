package com.onlinetest.admin.dao.impl;

import com.onlinetest.admin.dao.BaseDao;
import com.onlinetest.admin.dao.StudentDao;
import com.onlinetest.admin.entity.Student;
import com.onlinetest.admin.utils.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author JasonWu
 * @create 2020-01-11-15:46
 */
public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public List<Student> selectAll() {
        String sql = "select * from sys_student";
        List<Student> students = (List<Student>) executeQuery(new ResultSetProcessor() {
            @Override
            public Object process(ResultSet rs) throws SQLException {
                List<Student> list = new ArrayList<Student>();
                while (rs.next()) {
                    String studentId = rs.getString("student_id");
                    String studentNum = rs.getString("student_num");
                    String name = rs.getString("name");
                    String pwd = rs.getString("pwd");
                    String classId = rs.getString("class_id");
                    list.add(new Student(studentId,studentNum,name,pwd,classId));
                }
                return list;
            }
        }, sql);
        return students;
    }

    @Override
    public Student selectByKeyWord() {
        return null;
    }

    @Override
    public String insert(Student student) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String sql = "insert into sys_student (student_id, student_num, name, class_id, pwd) values (?, ?, ?, ?, ?)";
        executeUpdate(sql,uuid,student.getStudentNum(),student.getName(),student.getClassId(),student.getPwd());
        return uuid;
    }

    @Override
    public int deleteById(String studentId) {
        String sql = "delete from sys_student where student_id=?";
        return executeUpdate(sql, studentId);
    }

    @Override
    public int update(Student student) {
        String sql = "update sys_student set student_num=?,name=?,class_id=?,pwd=? where student_id=?";
        return executeUpdate(sql, student.getStudentNum(),student.getName(),student.getClassId(),student.getPwd(),student.getStudentId());
    }
}
