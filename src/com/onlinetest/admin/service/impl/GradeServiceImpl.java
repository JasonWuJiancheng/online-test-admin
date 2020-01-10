package com.onlinetest.admin.service.impl;

import com.onlinetest.admin.dao.GradeDao;
import com.onlinetest.admin.dao.impl.GradeDaoImpl;
import com.onlinetest.admin.entity.Grade;
import com.onlinetest.admin.service.GradeService;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-10-23:49
 */
public class GradeServiceImpl implements GradeService {

    private GradeDao gradeDao = new GradeDaoImpl();

    @Override
    public List<Grade> getAllGrade() {
        return gradeDao.selectAll();
    }

    @Override
    public int updateGrade(Grade grade) {
        return gradeDao.update(grade);
    }

    @Override
    public int deleteGrade(Grade grade) {
        return gradeDao.deleteById(grade.getGradeId());
    }

    @Override
    public int deleteGrades(List<Grade> grades) {
        int res = 0;
        if(grades!=null){
            for(Grade grade : grades){
                gradeDao.deleteById(grade.getGradeId());
            }
        }
        return res;
    }

    @Override
    public String insertGrade(Grade grade) {
        return gradeDao.insert(grade);
    }
}
