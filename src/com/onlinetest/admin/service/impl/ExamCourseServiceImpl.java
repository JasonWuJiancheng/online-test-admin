package com.onlinetest.admin.service.impl;

import com.onlinetest.admin.dao.ExamCourseDao;
import com.onlinetest.admin.dao.impl.ExamCourseDaoImpl;
import com.onlinetest.admin.entity.ExamCourse;
import com.onlinetest.admin.service.ExamCourseService;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-10-16:04
 */
public class ExamCourseServiceImpl implements ExamCourseService {

    private ExamCourseDao examCourseDao = new ExamCourseDaoImpl();

    @Override
    public List<ExamCourse> getAllExamCourse() {
        return examCourseDao.selectAll();
    }

    @Override
    public int updateExamCourse(ExamCourse examCourse) {
        return examCourseDao.update(examCourse);
    }

    @Override
    public int deleteExamCourse(ExamCourse examCourse) {
        return examCourseDao.deleteById(examCourse.getExamCourseId());
    }

    @Override
    public int deleteExamCourses(List<ExamCourse> examCourses) {
        int res = 0;
        if(examCourses!=null){
            for(ExamCourse examCourse : examCourses){
                examCourseDao.deleteById(examCourse.getExamCourseId());
            }
        }
        return res;
    }

    @Override
    public String insertExamCourse(ExamCourse examCourse) {
        return examCourseDao.insert(examCourse);
    }
}
