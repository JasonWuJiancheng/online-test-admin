package com.onlinetest.admin.service;

import com.onlinetest.admin.entity.Student;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-16:00
 */
public interface StudentService {

    List<Student> getAllStudent();

    int updateStudent(Student student);

    int deleteStudent(Student student);

    int deleteStudents(List<Student> students);

    String insertStudent(Student student);
}
