package com.imooc.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * 技术点： 自定义注解
 *          自定义初次鉴权过滤
 *          自定义认证信息等
 *          ...
 */
@SpringBootApplication
@EnableZuulProxy //开启网关代理
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}

