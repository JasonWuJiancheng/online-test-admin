package com.onlinetest.admin.dao;

import com.onlinetest.admin.entity.Student;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-11-15:44
 */
public interface StudentDao {

    List<Student> selectAll();

    Student selectByKeyWord();

    //返回刚插入的数据uuid
    String insert(Student student);

    int deleteById(String studentId);

    int update(Student student);

}
