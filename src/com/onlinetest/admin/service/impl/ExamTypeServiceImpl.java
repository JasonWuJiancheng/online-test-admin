package com.onlinetest.admin.service.impl;

import com.onlinetest.admin.dao.ExamTypeDao;
import com.onlinetest.admin.dao.impl.ExamTypeDaoImpl;
import com.onlinetest.admin.entity.ExamType;
import com.onlinetest.admin.service.ExamTypeService;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-16:04
 */
public class ExamTypeServiceImpl implements ExamTypeService {

    private ExamTypeDao examTypeDao = new ExamTypeDaoImpl();

    @Override
    public List<ExamType> getAllExamType() {
        return examTypeDao.selectAll();
    }

    @Override
    public int updateExamType(ExamType examType) {
        return examTypeDao.update(examType);
    }

    @Override
    public int deleteExamType(ExamType examType) {
        return examTypeDao.deleteById(examType.getExamTypeId());
    }

    @Override
    public int deleteExamTypes(List<ExamType> examTypes) {
        int res = 0;
        if(examTypes!=null){
            for(ExamType examType : examTypes){
                examTypeDao.deleteById(examType.getExamTypeId());
            }
        }
        return res;
    }

    @Override
    public String insertExamType(ExamType examType) {
        return examTypeDao.insert(examType);
    }
}
