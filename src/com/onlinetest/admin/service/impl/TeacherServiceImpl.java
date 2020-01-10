package com.onlinetest.admin.service.impl;

import com.onlinetest.admin.dao.TeacherDao;
import com.onlinetest.admin.dao.impl.TeacherDaoImpl;
import com.onlinetest.admin.entity.Teacher;
import com.onlinetest.admin.service.TeacherService;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-10-21:53
 */
public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao = new TeacherDaoImpl();

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.selectAll();
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherDao.update(teacher);
    }

    @Override
    public int deleteTeacher(Teacher teacher) {
        return teacherDao.deleteById(teacher.getTeacherId());
    }

    @Override
    public int deleteTeachers(List<Teacher> teachers) {
        int res = 0;
        if(teachers!=null){
            for(Teacher teacher : teachers){
                teacherDao.deleteById(teacher.getTeacherId());
            }
        }
        return res;
    }

    @Override
    public String insertTeacher(Teacher teacher) {
        return teacherDao.insert(teacher);
    }
}
