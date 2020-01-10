package com.onlinetest.admin.service;

import com.onlinetest.admin.entity.Teacher;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-16:00
 */
public interface TeacherService {

    List<Teacher> getAllTeacher();

    int updateTeacher(Teacher teacher);

    int deleteTeacher(Teacher teacher);

    int deleteTeachers(List<Teacher> teachers);

    String insertTeacher(Teacher teacher);

}
