package com.onlinetest.admin.servlet.exam;

import com.alibaba.fastjson.JSON;
import com.onlinetest.admin.entity.ExamType;
import com.onlinetest.admin.entity.Result;
import com.onlinetest.admin.service.ExamTypeService;
import com.onlinetest.admin.service.impl.ExamTypeServiceImpl;
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
@WebServlet(value = "/examtype")
public class ExamTypeServlet extends HttpServlet {

    private ExamTypeService examTypeService = new ExamTypeServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result result = null;

        //解析参数
        String method = req.getParameter("method");

        String examTypeId = req.getParameter("examTypeId");
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
                    List<ExamType> allExamType = examTypeService.getAllExamType();
                    if(allExamType==null){
                        result = new Result(false,ResCode.OPERATIONSUCCESS,ResMsg.FIND_NULL);
                    }else {
                        result = new Result(true,ResCode.OPERATIONSUCCESS,ResMsg.FIND_SUCCESS,allExamType);
                    }
                    break;
                case "add":
                    if(name==null || startTime==null || endTime==null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.ADD_FAULT);
                    }else {
                        ExamType examType = new ExamType(examTypeId, name, startTime, endTime);
                        String uuid = examTypeService.insertExamType(examType);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS,uuid);
                    }
                    break;
                case "dels":
                    rows = req.getParameter("rows");
                    if(rows == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        List<ExamType> examTypes= JSON.parseArray(rows,ExamType.class);
                        examTypeService.deleteExamTypes(examTypes);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除"+examTypes.size()+"条记录");
                    }
                    break;
                case "del":
                    row = req.getParameter("row");
                    if(row == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        ExamType examTypes= JSON.parseObject(row,ExamType.class);
                        examTypeService.deleteExamType(examTypes);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除1条记录");
                    }
                    break;
                case "update":
                    if(examTypeId==null || name==null || startTime==null || endTime==null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.SAVE_FAULT);
                    }else {
                        ExamType examType = new ExamType(examTypeId, name, startTime, endTime);
                        examTypeService.updateExamType(examType);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS);
                    }
                    break;
            }
        }
        //返回信息
        ResUtil.toJson(result,resp);
    }
}
