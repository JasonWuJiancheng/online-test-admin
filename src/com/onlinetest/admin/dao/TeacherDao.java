package com.onlinetest.admin.dao;

import com.onlinetest.admin.entity.Teacher;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-15:30
 */
public interface TeacherDao {

    List<Teacher> selectAll();

    Teacher selectByKeyWord();

    //返回刚插入的数据uuid
    String insert(Teacher teacher);

    int deleteById(String teacherId);

    int update(Teacher teacher);
}
