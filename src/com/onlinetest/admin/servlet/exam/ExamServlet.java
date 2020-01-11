package com.onlinetest.admin.servlet.exam;

import com.alibaba.fastjson.JSON;
import com.onlinetest.admin.entity.Exam;
import com.onlinetest.admin.entity.Result;
import com.onlinetest.admin.service.ExamService;
import com.onlinetest.admin.service.impl.ExamServiceImpl;
import com.onlinetest.admin.utils.ResCode;
import com.onlinetest.admin.utils.ResMsg;
import com.onlinetest.admin.utils.ResUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-07-16:41
 */
@WebServlet(value = "/exam")
public class ExamServlet extends HttpServlet {

    private ExamService examService = new ExamServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result result = null;

        //解析参数
        String method = req.getParameter("method");

        String rows = req.getParameter("rows");
        String row = req.getParameter("row");

        if("".equals(method) || method==null){
            //参数为空则查询错误
            result = new Result(false, ResCode.OPERATIONERROR, ResMsg.OPERATION_FAULT);
        }else{
            switch (method){
                case "all":
                    List<Exam> allExam = examService.getAllExam();
                    if(allExam==null){
                        result = new Result(false,ResCode.OPERATIONSUCCESS,ResMsg.FIND_NULL);
                    }else {
                        result = new Result(true,ResCode.OPERATIONSUCCESS,ResMsg.FIND_SUCCESS,allExam);
                    }
                    break;
                case "add":
                    if(row == null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.ADD_FAULT);
                    }else {
                        Exam exam= JSON.parseObject(row,Exam.class);
                        String uuid = examService.insertExam(exam);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.ADD_SUCCESS,uuid);
                    }
                    break;
                case "dels":
                    if(rows == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        List<Exam> exams= JSON.parseArray(rows,Exam.class);
                        examService.deleteExams(exams);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除"+exams.size()+"条记录");
                    }
                    break;
                case "del":
                    if(row == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        Exam exams= JSON.parseObject(row,Exam.class);
                        examService.deleteExam(exams);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除1条记录");
                    }
                    break;
                case "update":
                    if(row == null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.SAVE_FAULT);
                    }else {
                        Exam exam= JSON.parseObject(row,Exam.class);
                        examService.updateExam(exam);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS);
                    }
                    break;
            }
        }
        //返回信息
        ResUtil.toJson(result,resp);
    }
}
