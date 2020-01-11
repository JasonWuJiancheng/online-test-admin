package com.onlinetest.admin.service.impl;

import com.onlinetest.admin.dao.ExamDao;
import com.onlinetest.admin.dao.impl.ExamDaoImpl;
import com.onlinetest.admin.entity.Exam;
import com.onlinetest.admin.service.ExamService;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-11-21:39
 */
public class ExamServiceImpl implements ExamService {

    private ExamDao examDao = new ExamDaoImpl();

    @Override
    public List<Exam> getAllExam() {
        return examDao.selectAll();
    }

    @Override
    public int updateExam(Exam exam) {
        return examDao.update(exam);
    }

    @Override
    public int deleteExam(Exam exam) {
        return examDao.deleteById(exam.getExamId());
    }

    @Override
    public int deleteExams(List<Exam> exams) {
        int res = 0;
        if(exams!=null){
            for(Exam exam : exams){
                examDao.deleteById(exam.getExamId());
            }
        }
        return res;
    }

    @Override
    public String insertExam(Exam exam) {
        return examDao.insert(exam);
    }
}
