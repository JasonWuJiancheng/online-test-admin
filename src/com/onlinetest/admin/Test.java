package com.onlinetest.admin;

import com.onlinetest.admin.entity.ExamType;
import com.onlinetest.admin.service.ExamTypeService;
import com.onlinetest.admin.service.impl.ExamTypeServiceImpl;

/**
 * @author JasonWu
 * @create 2020-01-06-21:55
 */
public class Test {

    public static void main(String[] args) {

        ExamTypeService examTypeService = new ExamTypeServiceImpl();

        ExamType examType = new ExamType("1","2018-2019学年上半学期期末考试","20190511","20191116");
//        examTypeService.insertExamType(examType);

//        List<ExamType> allExamTypes = examTypeService.getAllExamType();
//        System.out.println(allExamTypes);

//        examTypeService.updateExamType(examType);
    }
}
