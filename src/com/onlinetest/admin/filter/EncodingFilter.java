package com.onlinetest.admin.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author JasonWu
 * @create 2019-12-19-20:55
 */
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //统一设置编码格式
        servletRequest.setCharacterEncoding("utf-8");

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String url= request.getRequestURI();
        if(url.indexOf(".css")>0||url.indexOf(".js")>0||url.indexOf(".png")>0) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
