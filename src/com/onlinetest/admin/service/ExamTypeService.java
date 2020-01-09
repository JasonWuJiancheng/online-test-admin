package com.onlinetest.admin.service;

import com.onlinetest.admin.entity.ExamType;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-16:00
 */
public interface ExamTypeService {

    List<ExamType> getAllExamType();

    int updateExamType(ExamType examType);

    int deleteExamType(ExamType examType);

    int deleteExamTypes(List<ExamType> examTypes);

    String insertExamType(ExamType examType);

}
