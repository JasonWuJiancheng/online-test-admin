package com.onlinetest.admin.servlet.exam;

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

        if("".equals(method) || method==null){
            //参数为空则查询错误
            result = new Result(false, ResCode.OPERATIONSUCCESS, ResMsg.OPERATION_FAULT);
            ResUtil.toJson(result,resp);
        }else{
            switch (method){
                case "all":
                    List<ExamType> allExamType = examTypeService.getAllExamType();
                    if(allExamType==null){
                        result = new Result(false,ResCode.OPERATIONSUCCESS,ResMsg.FIND_NULL);
                    }else {
                        result = new Result(true,ResCode.OPERATIONSUCCESS,ResMsg.FIND_SUCCESS,allExamType);
                    }
                    ResUtil.toJson(result,resp);
            }
        }

    }
}
