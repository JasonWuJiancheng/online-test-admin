package com.onlinetest.admin.servlet.sys;

import com.alibaba.fastjson.JSON;
import com.onlinetest.admin.entity.Class;
import com.onlinetest.admin.entity.Result;
import com.onlinetest.admin.service.ClassService;
import com.onlinetest.admin.service.impl.ClassServiceImpl;
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
@WebServlet(value = "/class")
public class ClassServlet extends HttpServlet {

    private ClassService classService = new ClassServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result result = null;

        //解析参数
        String method = req.getParameter("method");

        String classId = req.getParameter("classId");
        String majorId = req.getParameter("majorId");
        String gradeId = req.getParameter("gradeId");
        String name = req.getParameter("name");

        String rows = null;
        String row = null;

        if("".equals(method) || method==null){
            //参数为空则查询错误
            result = new Result(false, ResCode.OPERATIONSUCCESS, ResMsg.OPERATION_FAULT);
        }else{
            switch (method){
                case "all":
                    List<Class> allClass = classService.getAllClass();
                    if(allClass==null){
                        result = new Result(false,ResCode.OPERATIONSUCCESS,ResMsg.FIND_NULL);
                    }else {
                        result = new Result(true,ResCode.OPERATIONSUCCESS,ResMsg.FIND_SUCCESS,allClass);
                    }
                    break;
                case "add":
                    if(name==null || majorId==null || gradeId==null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.ADD_FAULT);
                    }else {
                        Class class1 = new Class(classId, majorId,gradeId,name);
                        String uuid = classService.insertClass(class1);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS,uuid);
                    }
                    break;
                case "dels":
                    rows = req.getParameter("rows");
                    if(rows == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        List<Class> classes= JSON.parseArray(rows,Class.class);
                        classService.deleteClasses(classes);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除"+classes.size()+"条记录");
                    }
                    break;
                case "del":
                    row = req.getParameter("row");
                    if(row == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        Class class1= JSON.parseObject(row,Class.class);
                        classService.deleteClass(class1);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除1条记录");
                    }
                    break;
                case "update":
                    if(classId==null || name==null || majorId==null || gradeId==null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.SAVE_FAULT);
                    }else {
                        Class class1 = new Class(classId, majorId,gradeId,name);
                        classService.updateClass(class1);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS);
                    }
                    break;
            }
        }
        //返回信息
        ResUtil.toJson(result,resp);
    }
}
