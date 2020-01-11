package com.onlinetest.admin.service.impl;

import com.onlinetest.admin.dao.ClassDao;
import com.onlinetest.admin.dao.impl.ClassDaoImpl;
import com.onlinetest.admin.entity.Class;
import com.onlinetest.admin.service.ClassService;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-11-13:55
 */
public class ClassServiceImpl implements ClassService {

    private ClassDao classDao = new ClassDaoImpl();

    @Override
    public List<Class> getAllClass() {
        return classDao.selectAll();
    }

    @Override
    public int updateClass(Class class1) {
        return classDao.update(class1);
    }

    @Override
    public int deleteClass(Class class1) {
        return classDao.deleteById(class1.getClassId());
    }

    @Override
    public int deleteClasses(List<Class> classes) {
        int res = 0;
        if(classes!=null){
            for(Class class1 : classes){
                classDao.deleteById(class1.getClassId());
            }
        }
        return res;
    }

    @Override
    public String insertClass(Class class1) {
        return classDao.insert(class1);
    }
}
