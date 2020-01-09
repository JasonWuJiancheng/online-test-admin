package com.onlinetest.admin.dao;

import com.onlinetest.admin.entity.ExamType;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-15:30
 */
public interface ExamTypeDao {

    List<ExamType> selectAll();

    ExamType selectByKeyWord();

    //返回刚插入的数据uuid
    String insert(ExamType examType);

    int deleteById(String examTypeId);

    int update(ExamType examType);
}
