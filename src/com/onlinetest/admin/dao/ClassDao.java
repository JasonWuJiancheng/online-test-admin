package com.onlinetest.admin.dao;

import com.onlinetest.admin.entity.Class;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-15:30
 */
public interface ClassDao {

    List<Class> selectAll();

    List<Class> selectByKeyWord(String majorId,String gradeId);

    Class selectById(String classId);

    //返回刚插入的数据uuid
    String insert(Class class1);

    int deleteById(String classId);

    int update(Class class1);
}
