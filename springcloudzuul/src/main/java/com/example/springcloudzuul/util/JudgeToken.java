package com.example.springcloudzuul.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @Author: xqr
 * @Date: 2021/7/7 13:48
 */
public class JudgeToken {

    public static boolean judgeToken(String token){
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!@adhkajshd")).build();
            DecodedJWT jwt= jwtVerifier.verify(token);
            int uid=jwt.getClaims().get("id").asInt();
            return false;
        }catch (Exception e){

            return true;
        }


    }
}
