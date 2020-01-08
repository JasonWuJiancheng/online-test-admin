package com.onlinetest.admin;

import com.onlinetest.admin.entity.ExamType;
import com.onlinetest.admin.service.ExamTypeService;
import com.onlinetest.admin.service.impl.ExamTypeServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author JasonWu
 * @create 2020-01-06-21:55
 */
public class Test {

    public static void main(String[] args) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = null;
        LocalDateTime end = null;
        String time1 = null;
        String time2 = null;
        ExamTypeService examTypeService = new ExamTypeServiceImpl();
        for(int i=0;i<99;i++){
            start = LocalDateTime.now().plusHours(i*10);
            end = LocalDateTime.now().plusDays(i);
            time1 = dateTimeFormatter.format(start);
            time2 = dateTimeFormatter.format(end);
            ExamType examType = new ExamType(i+"","期末考试"+i,time1,time2);
            examTypeService.insertExamType(examType);
        }

    }
}
