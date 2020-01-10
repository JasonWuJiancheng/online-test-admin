package com.onlinetest.admin.service;

import com.onlinetest.admin.entity.Grade;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-16:00
 */
public interface GradeService {

    List<Grade> getAllGrade();

    int updateGrade(Grade grade);

    int deleteGrade(Grade grade);

    int deleteGrades(List<Grade> grades);

    String insertGrade(Grade grade);

}
