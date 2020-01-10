package com.onlinetest.admin.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JasonWu
 * @create 2019-12-19-20:55
 */
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //放行指定页面
        final String uri = request.getRequestURI().startsWith("/") ? request.getRequestURI().substring(1) : request.getRequestURI();
        if(uri.endsWith("login.html") || uri.endsWith("login") || uri.endsWith(".js")
                || uri.endsWith(".css") || uri.endsWith(".png") || uri.endsWith(".woff2")
                || uri.endsWith(".woff") || uri.endsWith(".ttf")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else {
            //统一判断session
            if(request.getSession(false) == null){
                //重新跳转登录页面
                System.out.println("SessionFilter-doFilter(): 用户未登录拦截"+uri);
                response.sendRedirect("/login.html");
            }else{
                //放行
                System.out.println("SessionFilter-doFilter(): 用户已登录-放行");
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
