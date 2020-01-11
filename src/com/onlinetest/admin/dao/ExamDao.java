package com.onlinetest.admin.dao;

import com.onlinetest.admin.entity.Exam;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-15:30
 */
public interface ExamDao {

    List<Exam> selectAll();

    Exam selectByKeyWord();

    //返回刚插入的数据uuid
    String insert(Exam exam);

    int deleteById(String examId);

    int update(Exam exam);
}
