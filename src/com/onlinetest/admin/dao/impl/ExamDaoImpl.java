package com.onlinetest.admin.dao.impl;

import com.onlinetest.admin.dao.BaseDao;
import com.onlinetest.admin.dao.ExamDao;
import com.onlinetest.admin.entity.Exam;
import com.onlinetest.admin.utils.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author JasonWu
 * @create 2020-01-11-21:24
 */
public class ExamDaoImpl extends BaseDao implements ExamDao {

    @Override
    public List<Exam> selectAll() {
        String sql = "select exams.*,exam_type.`NAME` eTypeName,sys_teacher.`NAME` teaName,exam_course.`NAME` courseName from exams,sys_teacher,exam_course,exam_type where exams.courseId=exam_course.EXAM_COURSE_ID and exams.teaId=sys_teacher.TEACHER_ID and exams.eTypeId=exam_type.EXAM_TYPE_ID";
        List<Exam> examCourses = (List<Exam>) executeQuery(new ResultSetProcessor() {
            @Override
            public Object process(ResultSet rs) throws SQLException {
                List<Exam> list = new ArrayList<Exam>();
                while (rs.next()) {
                    String examId = rs.getString("examId");
                    String examName = rs.getString("examName");
                    String eTypeId = rs.getString("eTypeId");
                    String teaId = rs.getString("teaId");
                    String courseId = rs.getString("courseId");
                    String sTime = rs.getString("sTime");
                    String eTime = rs.getString("eTime");
                    int isComp = rs.getInt("isComp");
                    int isJoin = rs.getInt("isJoin");
                    String cTime = rs.getString("cTime");

                    String eTypeName = rs.getString("eTypeName");
                    String teaName = rs.getString("teaName");
                    String courseName = rs.getString("courseName");
                    list.add(new Exam(examId,examName,eTypeId, teaId, courseId,sTime,eTime,isComp,isJoin,cTime,eTypeName,teaName,courseName));
                }
                return list;
            }
        }, sql);
        return examCourses;
    }

    @Override
    public Exam selectByKeyWord() {
        return null;
    }

    @Override
    public String insert(Exam exam) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String sql = "insert into exams (examId, examName, eTypeId, teaId, courseId, sTime, eTime, isComp, isJoin, cTime) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        executeUpdate(sql,uuid,exam.getExamName(),exam.geteTypeId(),exam.getTeaId(),exam.getCourseId(),
                exam.getsTime(),exam.geteTime(),exam.getIsComp(),exam.getIsJoin(),exam.getcTime());
        return uuid;
    }

    @Override
    public int deleteById(String examId) {
        String sql = "delete from exams where examId=?";
        return executeUpdate(sql, examId);
    }

    @Override
    public int update(Exam exam) {
        String sql = "update exams set examName=?, eTypeId=?, teaId=?, courseId=?, sTime=?, eTime=?, isComp=?, isJoin=?, cTime=?  where examId=?";
        return executeUpdate(sql,exam.getExamName(),exam.geteTypeId(),exam.getTeaId(),exam.getCourseId(),
                exam.getsTime(),exam.geteTime(),exam.getIsComp(),exam.getIsJoin(),exam.getcTime(),exam.getExamId());
    }
}
