package com.imooc.user.common.auth.jwt.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.imooc.user.common.auth.jwt.token.ConstantToken.TOKEN_SECRET;

public class SignAuth {
    public static void main(String[] args) {
        String lucy = sign("lucy", "123456");
        System.err.println(lucy);
    }
    /**
     * 生成签名，15分钟过期
     * @param **username**
     * @param **password**
     * @return   实现签名方法： 这里不应该使用密码进行加密，不安全，但是是自己的小demo就这样写了。
     */
    public static String sign(String username, String password) {
        try {
            // 设置过期时间=当前时间+过期时间
            Date date = new Date(System.currentTimeMillis() + ConstantToken.EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("loginName", username)
                    .withClaim("pwd", password)
                    .withExpiresAt(date)//过期时间
                    .sign(algorithm);//签名认证
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检验token是否正确
     * @param **token**
     * @return
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;//TOKEN未过期
        } catch (Exception e){
            return false;//TOKEN过期
        }
    }
    /**
     * 从token中获取username信息
     * @param **token**
     * @return
     */
    public static String getUserName(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("loginName").asString();
        } catch (JWTDecodeException e){
            e.printStackTrace();
            return null;
        }
    }
}
