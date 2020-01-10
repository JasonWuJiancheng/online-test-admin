package com.onlinetest.admin.dao.impl;

import com.onlinetest.admin.dao.BaseDao;
import com.onlinetest.admin.dao.ExamCourseDao;
import com.onlinetest.admin.entity.ExamCourse;
import com.onlinetest.admin.utils.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author JasonWu
 * @create 2020-01-07-15:36
 */
public class ExamCourseDaoImpl extends BaseDao implements ExamCourseDao {

    @Override
    public List<ExamCourse> selectAll() {
        String sql = "select * from exam_course";
        List<ExamCourse> examCourses = (List<ExamCourse>) executeQuery(new ResultSetProcessor() {

            @Override
            public Object process(ResultSet rs) throws SQLException {
                List<ExamCourse> list = new ArrayList<ExamCourse>();
                while (rs.next()) {
                    String examCourseId = rs.getString("exam_course_id");
                    String name = rs.getString("name");
                    String startTime = rs.getString("start_time");
                    String endTime = rs.getString("end_time");
                    list.add(new ExamCourse(examCourseId,name, startTime, endTime));
                }
                return list;
            }
        }, sql);
        return examCourses;
    }

    @Override
    public ExamCourse selectByKeyWord() {
        return null;
    }

    @Override
    public String insert(ExamCourse examCourse) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String sql = "insert into exam_course (exam_course_id, name, start_time, end_time) values (?, ?, ?, ?)";
        executeUpdate(sql,uuid,examCourse.getName(),examCourse.getStartTime(),examCourse.getEndTime());
        return uuid;
    }

    @Override
    public int deleteById(String examCourseId) {
        String sql = "delete from exam_course where exam_course_id=?";
        return executeUpdate(sql, examCourseId);
    }

    @Override
    public int update(ExamCourse examCourse) {
        String sql = "update exam_course set name=?, start_time=?, end_time=? where exam_course_id=?";
        return executeUpdate(sql, examCourse.getName(),examCourse.getStartTime(),examCourse.getEndTime(),examCourse.getExamCourseId());
    }
}
