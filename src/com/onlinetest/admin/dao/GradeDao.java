package com.onlinetest.admin.dao;

import com.onlinetest.admin.entity.Grade;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-15:30
 */
public interface GradeDao {

    List<Grade> selectAll();

    Grade selectByKeyWord();

    //返回刚插入的数据uuid
    String insert(Grade grade);

    int deleteById(String gradeId);

    int update(Grade grade);
}
