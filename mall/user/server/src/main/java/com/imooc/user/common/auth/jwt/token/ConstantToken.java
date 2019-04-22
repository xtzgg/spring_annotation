package com.imooc.user.common.auth.jwt.token;

/**
 * 首先定义token的过期时间和私钥
 */
public class ConstantToken {
    public static final long EXPIRE_TIME = 60 * 1000;//过期时间
    public static final String TOKEN_SECRET = "thefirsttoken123";//秘钥
}
