package com.onlinetest.admin.service;

import com.onlinetest.admin.entity.Class;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-16:00
 */
public interface ClassService {

    List<Class> getAllClass();

    int updateClass(Class class1);

    int deleteClass(Class class1);

    int deleteClasses(List<Class> classes);

    String insertClass(Class class1);

}
