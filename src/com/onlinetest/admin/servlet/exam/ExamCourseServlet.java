package com.onlinetest.admin.servlet.exam;

import com.alibaba.fastjson.JSON;
import com.onlinetest.admin.entity.ExamCourse;
import com.onlinetest.admin.entity.Result;
import com.onlinetest.admin.service.ExamCourseService;
import com.onlinetest.admin.service.impl.ExamCourseServiceImpl;
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
@WebServlet(value = "/examcourse")
public class ExamCourseServlet extends HttpServlet {

    private ExamCourseService examCourseService = new ExamCourseServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result result = null;

        //解析参数
        String method = req.getParameter("method");

        String examCourseId = req.getParameter("examCourseId");
        String name = req.getParameter("name");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");

        String rows = null;
        String row = null;

        if("".equals(method) || method==null){
            //参数为空则查询错误
            result = new Result(false, ResCode.OPERATIONSUCCESS, ResMsg.OPERATION_FAULT);
        }else{
            switch (method){
                case "all":
                    List<ExamCourse> allExamCourse = examCourseService.getAllExamCourse();
                    if(allExamCourse==null){
                        result = new Result(false,ResCode.OPERATIONSUCCESS,ResMsg.FIND_NULL);
                    }else {
                        result = new Result(true,ResCode.OPERATIONSUCCESS,ResMsg.FIND_SUCCESS,allExamCourse);
                    }
                    break;
                case "add":
                    if(name==null || startTime==null || endTime==null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.ADD_FAULT);
                    }else {
                        ExamCourse examCourse = new ExamCourse(examCourseId, name, startTime, endTime);
                        String uuid = examCourseService.insertExamCourse(examCourse);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS,uuid);
                    }
                    break;
                case "dels":
                    rows = req.getParameter("rows");
                    if(rows == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        List<ExamCourse> examCourses= JSON.parseArray(rows,ExamCourse.class);
                        examCourseService.deleteExamCourses(examCourses);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除"+examCourses.size()+"条记录");
                    }
                    break;
                case "del":
                    row = req.getParameter("row");
                    if(row == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        ExamCourse examCourses= JSON.parseObject(row,ExamCourse.class);
                        examCourseService.deleteExamCourse(examCourses);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除1条记录");
                    }
                    break;
                case "update":
                    if(examCourseId==null || name==null || startTime==null || endTime==null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.SAVE_FAULT);
                    }else {
                        ExamCourse examCourse = new ExamCourse(examCourseId, name, startTime, endTime);
                        examCourseService.updateExamCourse(examCourse);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS);
                    }
                    break;
            }
        }
        //返回信息
        ResUtil.toJson(result,resp);
    }
}
