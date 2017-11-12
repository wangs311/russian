package com.bluemsun.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/18 19:17
 */
public class FrontInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String uri = request.getRequestURI().substring(6);
        if(uri.contains("back")) {
            if(uri.equals("backTeacherController/login")) {
                return true;
            }else if(session.getAttribute("teacher") != null) {
                return true;
            }
            response.sendRedirect("/exam/loginBack.jsp");
            return false;
        }
        if(uri.equals("studentController/login")) {
            return true;
        }else if(session.getAttribute("student") != null) {
            return true;
        }
        response.sendRedirect("/exam/login.jsp");
        return false;

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
