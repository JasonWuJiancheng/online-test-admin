package com.onlinetest.admin.service.impl;

import com.onlinetest.admin.dao.ClassDao;
import com.onlinetest.admin.dao.StudentDao;
import com.onlinetest.admin.dao.impl.ClassDaoImpl;
import com.onlinetest.admin.dao.impl.StudentDaoImpl;
import com.onlinetest.admin.entity.Class;
import com.onlinetest.admin.entity.Student;
import com.onlinetest.admin.service.StudentService;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-11-16:00
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();
    private ClassDao classDao = new ClassDaoImpl();

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = studentDao.selectAll();
        Class temp = null;
        for(Student student : students){
            temp = classDao.selectById(student.getClassId());
            student.setMajorId(temp.getMajorId());
            student.setMajorName(temp.getMajorName());
            student.setGradeId(temp.getGradeId());
            student.setGradeName(temp.getGradeName());
            student.setClassName(temp.getName());
        }
        return students;
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int deleteStudent(Student student) {
        return studentDao.deleteById(student.getStudentId());
    }

    @Override
    public int deleteStudents(List<Student> students) {
        int res = 0;
        if(students!=null){
            for(Student student : students){
                studentDao.deleteById(student.getStudentId());
            }
        }
        return res;
    }

    @Override
    public String insertStudent(Student student) {
        return studentDao.insert(student);
    }

}
