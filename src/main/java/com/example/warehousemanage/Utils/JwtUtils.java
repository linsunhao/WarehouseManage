package com.example.warehousemanage.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.util.Date;

public class JwtUtils {
    //设置日期为7天过期
    private static long expire = 604800;
    //设置密钥为32位
    private static String secret = "abcdefghiabcdefghiabcdefghi";

    //生成token
    public static String generateToken(String no){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder()
                //设置Header
                .setHeaderParam("type","JWT")
                //设置payload载荷，一般使用登录用户的信息作为载荷
                .setSubject(no)
                //设置发出（生效）时间
                .setIssuedAt(now)
                //设置expiration过期时间
                .setExpiration(expiration)
                //设置签名加密算法,需要通过secret密钥来加密
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    //Claims类用于验证和存储用户信息,即载荷
    //解析token
    public static Claims getClaimsByToken(String token){
        return Jwts.parser()
                //获取secret密钥来进行解密
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
