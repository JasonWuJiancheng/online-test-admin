package com.onlinetest.admin.service;

import com.onlinetest.admin.entity.ExamCourse;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-16:00
 */
public interface ExamCourseService {

    List<ExamCourse> getAllExamCourse();

    int updateExamCourse(ExamCourse examCourse);

    int deleteExamCourse(ExamCourse examCourse);

    int deleteExamCourses(List<ExamCourse> examCourses);

    String insertExamCourse(ExamCourse examCourse);

}
