package com.imooc.user.common.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

public class JWTToken {
/*    public static void main(String[] args) {
        if(claims != null){
            String strUserId = claims.getSubject();
            request.setAttribute("userId", strUserId);
            String strOrgId = claims.get("orgId", String.class);
            request.setAttribute("orgId", strOrgId);
            return true;
        }
    }
    *//**
     * crateToken
     * @param strUserId
     * @param strOrgId
     * @return
     *//*
    public String createToken(String strUserId, String strOrgId) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        long ttlMillis = nowMillis + (3600L * 1000L * time);
        Date now = new Date(nowMillis);
        Date exp = new Date(ttlMillis);
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("orgId", strOrgId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .setId("1")
                .setIssuedAt(now)
                .setExpiration(exp)
                .setSubject(strUserId)
                .signWith(signatureAlgorithm, generalKey());
        return jwtBuilder.compact();
    }
    *//**
     * getToken
     *//*
    public Claims getToken(String token) throws Exception{
        Claims claims = Jwts.parser()
                .setSigningKey(generalKey())
                .parseClaimsJws(token)
                .getBody();
        return claims;

    }*/

}
