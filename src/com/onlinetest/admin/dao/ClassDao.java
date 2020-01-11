package com.onlinetest.admin.dao;

import com.onlinetest.admin.entity.Class;
import com.onlinetest.admin.entity.Grade;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-15:30
 */
public interface ClassDao {

    List<Class> selectAll();

    Grade selectByKeyWord();

    //返回刚插入的数据uuid
    String insert(Class class1);

    int deleteById(String classId);

    int update(Class class1);
}
