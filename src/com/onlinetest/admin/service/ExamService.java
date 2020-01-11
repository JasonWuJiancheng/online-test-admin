package com.onlinetest.admin.service;

import com.onlinetest.admin.entity.Exam;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-11-21:38
 */
public interface ExamService {

    List<Exam> getAllExam();

    int updateExam(Exam exam);

    int deleteExam(Exam exam);

    int deleteExams(List<Exam> exams);

    String insertExam(Exam exam);

}
