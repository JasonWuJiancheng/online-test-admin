package com.onlinetest.admin.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.onlinetest.admin.entity.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author JasonWu
 * @create 2020-01-07-20:52
 */
public class ResUtil {

    public static void toJson(Result result, HttpServletResponse response) {
        response.setContentType("text/json");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            String json = JSONObject.toJSONString(result,
                    SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullNumberAsZero,
                    SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.WriteNullStringAsEmpty,
                    SerializerFeature.WriteNullBooleanAsFalse,
                    SerializerFeature.DisableCircularReferenceDetect);
            out.write(json);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
