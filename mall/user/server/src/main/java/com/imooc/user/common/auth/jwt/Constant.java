package com.imooc.user.common.auth.jwt;

/**
 * 所以注意一点，payload 是一定不能够携带敏感数据如密码等信息的。
 *
 * jwt 唯一存储在服务端的只有一个 secret，个人认为这个 secret 应该设计成和用户相关的属性，
 * 而不是一个所有用户公用的统一值。这样可以有效的避免一些注销和修改密码时遇到的窘境。
 */
public class Constant {
    public static final String  JWT_SECRET ="7786df7fc3a34e26a61c034d5ec8245d"; //秘钥
    //public static final String  JWT_SECRET ="23243545465ddsd4e26a61c034d5ec8245d";
    public static final long EXPIRE_TIME = 60 * 1000 ; //过期时间一分钟
}
