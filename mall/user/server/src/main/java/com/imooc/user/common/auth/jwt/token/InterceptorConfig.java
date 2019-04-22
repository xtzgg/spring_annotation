package com.imooc.user.common.auth.jwt.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置拦截器
 *      对登录界面的请求不拦截
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    public InterceptorConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        String sysUserLogin = "/api/sysUser/login";
        excludePath.add("/user/buyer");
        excludePath.add("/user/seller");
        registry.addInterceptor(tokenInterceptor).excludePathPatterns(excludePath);
    }
}