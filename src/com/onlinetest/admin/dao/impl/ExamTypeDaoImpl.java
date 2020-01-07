package com.onlinetest.admin.dao.impl;

import com.onlinetest.admin.dao.BaseDao;
import com.onlinetest.admin.dao.ExamTypeDao;
import com.onlinetest.admin.entity.ExamType;
import com.onlinetest.admin.utils.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-15:36
 */
public class ExamTypeDaoImpl extends BaseDao implements ExamTypeDao {
    @Override
    public List<ExamType> selectAll() {
        String sql = "select * from exam_type";
        List<ExamType> examTypes = (List<ExamType>) executeQuery(new ResultSetProcessor() {

            @Override
            public Object process(ResultSet rs) throws SQLException {
                List<ExamType> examTypes = new ArrayList<ExamType>();
                while (rs.next()) {
                    String examTypeId = rs.getString("exam_type_id");
                    String name = rs.getString("name");
                    String startTime = rs.getString("start_time");
                    String endTime = rs.getString("end_time");
                    examTypes.add(new ExamType(examTypeId,name, startTime, endTime));
                }
                return examTypes;
            }
        }, sql);
        return examTypes;
    }

    @Override
    public ExamType selectByKeyWord() {
        return null;
    }

    @Override
    public int insert(ExamType examType) {
        String sql = "insert into exam_type (exam_type_id, name, start_time, end_time) values (replace(uuid(), '-', ''), ?, ?, ?)";
        return executeUpdate(sql,examType.getName(),examType.getStartTime(),examType.getEndTime());
    }

    @Override
    public int deleteById(String examTypeId) {
        String sql = "delete from exam_type where exam_type_id=?";
        return executeUpdate(sql, examTypeId);
    }

    @Override
    public int update(ExamType examType) {
        String sql = "update exam_type set name=?, start_time=?, end_time=? where exam_type_id=?";
        return executeUpdate(sql, examType.getName(),examType.getStartTime(),examType.getEndTime(),examType.getExamTypeId());
    }
}
