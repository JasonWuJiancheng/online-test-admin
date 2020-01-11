package com.onlinetest.admin.servlet.sys;

import com.alibaba.fastjson.JSON;
import com.onlinetest.admin.entity.Major;
import com.onlinetest.admin.entity.Result;
import com.onlinetest.admin.service.MajorService;
import com.onlinetest.admin.service.impl.MajorServiceImpl;
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
@WebServlet(value = "/major")
public class MajorServlet extends HttpServlet {

    private MajorService majorService = new MajorServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result result = null;

        //解析参数
        String method = req.getParameter("method");

        String majorId = req.getParameter("majorId");
        String name = req.getParameter("name");

        String rows = null;
        String row = null;

        if("".equals(method) || method==null){
            //参数为空则查询错误
            result = new Result(false, ResCode.OPERATIONSUCCESS, ResMsg.OPERATION_FAULT);
        }else{
            switch (method){
                case "all":
                    List<Major> allMajor = majorService.getAllMajor();
                    if(allMajor==null){
                        result = new Result(false,ResCode.OPERATIONSUCCESS,ResMsg.FIND_NULL);
                    }else {
                        result = new Result(true,ResCode.OPERATIONSUCCESS,ResMsg.FIND_SUCCESS,allMajor);
                    }
                    break;
                case "add":
                    if(name==null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.ADD_FAULT);
                    }else {
                        Major major = new Major(majorId, name);
                        String uuid = majorService.insertMajor(major);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS,uuid);
                    }
                    break;
                case "dels":
                    rows = req.getParameter("rows");
                    if(rows == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        List<Major> majors= JSON.parseArray(rows,Major.class);
                        majorService.deleteMajors(majors);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除"+majors.size()+"条记录");
                    }
                    break;
                case "del":
                    row = req.getParameter("row");
                    if(row == null){
                        result = new Result(false,ResCode.REMOVEERROR,ResMsg.REMOVE_FAULT);
                    }else {
                        Major majors= JSON.parseObject(row,Major.class);
                        majorService.deleteMajor(majors);
                        result = new Result(true,ResCode.REMOVESUCCESS,ResMsg.REMOVE_SUCCESS+",已删除1条记录");
                    }
                    break;
                case "update":
                    if(majorId==null || name==null){
                        result = new Result(false,ResCode.SAVEERROR,ResMsg.SAVE_FAULT);
                    }else {
                        Major major = new Major(majorId, name);
                        majorService.updateMajor(major);
                        result = new Result(true,ResCode.SAVESUCCESS,ResMsg.SAVE_SUCCESS);
                    }
                    break;
            }
        }
        //返回信息
        ResUtil.toJson(result,resp);
    }
}
