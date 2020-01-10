package com.onlinetest.admin.dao;

import com.onlinetest.admin.entity.ExamCourse;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-15:30
 */
public interface ExamCourseDao {

    List<ExamCourse> selectAll();

    ExamCourse selectByKeyWord();

    //返回刚插入的数据uuid
    String insert(ExamCourse examCourse);

    int deleteById(String examCourseId);

    int update(ExamCourse examCourse);
}
