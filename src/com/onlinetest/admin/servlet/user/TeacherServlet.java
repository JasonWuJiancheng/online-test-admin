package com.onlinetest.admin.servlet.user;

import com.alibaba.fastjson.JSON;
import com.onlinetest.admin.entity.Teacher;
import com.onlinetest.admin.entity.Result;
import com.onlinetest.admin.service.TeacherService;
import com.onlinetest.admin.service.impl.TeacherServiceImpl;
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
@WebServlet(value = "/teacher")
public class TeacherServlet extends HttpServlet {

    private TeacherService TeacherService = new TeacherServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result result = null;

        //解析参数
        String method = req.getParameter("method");

        String teacherId = req.getParameter("teacherId");
        String name = req.getParameter("name");

        String rows = null;
        String row = null;

        if("".equals(method) || method==null){
            //参数为空则查询错误
            result = new Result(false, ResCode.OPERATIONSUCCESS, ResMsg.OPERATION_FAULT);
        }else{
            switch (method){
                case "all":
                    List<Teacher> allTeacher = TeacherService.getAllTeacher();
                    if(allTeacher==null){
                        result = new Result(false,ResCode.OPERATIONSUCCESS,ResMsg.FIND_NULL);
                    }else {
                        result = new Result(true,ResCode.OPERATIONSUCCESS,ResMsg.FIND_SUCCESS,allTeacher);
                    }
                    break;
                case "add":
                    if(name==null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.ADD_FAULT);
                    }else {
                        Teacher teacher = new Teacher(teacherId, name);
                        String uuid = TeacherService.insertTeacher(teacher);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS,uuid);
                    }
                    break;
                case "dels":
                    rows = req.getParameter("rows");
                    if(rows == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        List<Teacher> teachers= JSON.parseArray(rows,Teacher.class);
                        TeacherService.deleteTeachers(teachers);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除"+teachers.size()+"条记录");
                    }
                    break;
                case "del":
                    row = req.getParameter("row");
                    if(row == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        Teacher teachers= JSON.parseObject(row,Teacher.class);
                        TeacherService.deleteTeacher(teachers);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除1条记录");
                    }
                    break;
                case "update":
                    if(teacherId==null || name==null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.SAVE_FAULT);
                    }else {
                        Teacher teacher = new Teacher(teacherId, name);
                        TeacherService.updateTeacher(teacher);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS);
                    }
                    break;
            }
        }
        //返回信息
        ResUtil.toJson(result,resp);
    }
}
