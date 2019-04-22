package com.imooc.user.common.auth.jwt.token;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义token拦截器
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        if(request.getRequestURI().contains("/user/buyer")){
            return true;
        }
        String token = "";
        response.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("admin-token")){
                token=cookie.getValue();
            }
        }
       // String token = request.getHeader("admin-token");
        if (token != null){
            boolean result = SignAuth.verify(token);
            if(result){
                System.out.println("通过拦截器");
                return true;
            }
        }
        System.out.println("认证失败");
        response.getWriter().write("50000");
        return false;
    }
}