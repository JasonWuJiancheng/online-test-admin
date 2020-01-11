package com.onlinetest.admin.dao.impl;

import com.onlinetest.admin.dao.BaseDao;
import com.onlinetest.admin.dao.ClassDao;
import com.onlinetest.admin.entity.Class;
import com.onlinetest.admin.utils.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author JasonWu
 * @create 2020-01-11-13:49
 */
public class ClassDaoImpl extends BaseDao implements ClassDao {
    @Override
    public List<Class> selectAll() {
        String sql = "select CLASS_ID,sys_class.MAJOR_ID,sys_major.`NAME` MAJOR_NAME," +
                "sys_class.GRADE_ID,sys_grade.`NAME` GRADE_NAME,sys_class.`NAME` from sys_class," +
                "sys_major,sys_grade where sys_class.MAJOR_ID=sys_major.MAJOR_ID and" +
                " sys_class.GRADE_ID=sys_grade.GRADE_ID";
        List<Class> classes = (List<Class>) executeQuery(new ResultSetProcessor() {

            @Override
            public Object process(ResultSet rs) throws SQLException {
                List<Class> list = new ArrayList<Class>();
                while (rs.next()) {
                    String classId = rs.getString("class_id");
                    String majorId = rs.getString("major_id");
                    String majorName = rs.getString("major_name");
                    String gradeId = rs.getString("grade_id");
                    String gradeName = rs.getString("grade_name");
                    String name = rs.getString("name");
                    list.add(new Class(classId,majorId,majorName,gradeId,gradeName,name));
                }
                return list;
            }
        }, sql);
        return classes;
    }

    @Override
    public List<Class> selectByKeyWord(String majorId,String gradeId) {
        String sql = "select CLASS_ID,sys_class.MAJOR_ID,sys_major.`NAME` MAJOR_NAME," +
                "sys_class.GRADE_ID,sys_grade.`NAME` GRADE_NAME,sys_class.`NAME` from sys_class," +
                "sys_major,sys_grade where sys_class.MAJOR_ID=sys_major.MAJOR_ID and" +
                " sys_class.GRADE_ID=sys_grade.GRADE_ID and sys_class.MAJOR_ID=? and sys_class.GRADE_ID=?";
        List<Class> classes = (List<Class>) executeQuery(new ResultSetProcessor() {

            @Override
            public Object process(ResultSet rs) throws SQLException {
                List<Class> list = new ArrayList<Class>();
                while (rs.next()) {
                    String classId = rs.getString("class_id");
                    String majorId = rs.getString("major_id");
                    String majorName = rs.getString("major_name");
                    String gradeId = rs.getString("grade_id");
                    String gradeName = rs.getString("grade_name");
                    String name = rs.getString("name");
                    list.add(new Class(classId,majorId,majorName,gradeId,gradeName,name));
                }
                return list;
            }
        }, sql,majorId,gradeId);
        return classes;
    }

    @Override
    public Class selectById(String classId) {
        String sql = "select CLASS_ID,sys_class.MAJOR_ID,sys_major.`NAME` MAJOR_NAME," +
                "sys_class.GRADE_ID,sys_grade.`NAME` GRADE_NAME,sys_class.`NAME` from sys_class," +
                "sys_major,sys_grade where sys_class.MAJOR_ID=sys_major.MAJOR_ID and" +
                " sys_class.GRADE_ID=sys_grade.GRADE_ID and sys_class.class_ID=?";
        Class class1 = (Class) executeQuery(new ResultSetProcessor() {

            @Override
            public Object process(ResultSet rs) throws SQLException {
                while (rs.next()) {
                    String classId = rs.getString("class_id");
                    String majorId = rs.getString("major_id");
                    String majorName = rs.getString("major_name");
                    String gradeId = rs.getString("grade_id");
                    String gradeName = rs.getString("grade_name");
                    String name = rs.getString("name");
                    return new Class(classId,majorId,majorName,gradeId,gradeName,name);
                }
                return null;
            }
        }, sql,classId);
        return class1;
    }

    @Override
    public String insert(Class class1) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String sql = "insert into sys_class (class_id,major_id,grade_id,name) values (?, ?, ?, ?)";
        executeUpdate(sql,uuid,class1.getMajorId(),class1.getGradeId(),class1.getName());
        return uuid;
    }

    @Override
    public int deleteById(String classId) {
        String sql = "delete from sys_class where class_id=?";
        return executeUpdate(sql, classId);
    }

    @Override
    public int update(Class class1) {
        String sql = "update sys_class set major_id=?,grade_id=?,name=? where class_id=?";
        return executeUpdate(sql, class1.getMajorId(),class1.getGradeId(),class1.getName(),class1.getClassId());
    }
}
