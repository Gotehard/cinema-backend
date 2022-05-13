package pl.macstr.cinema.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenService {
    public static String createToken(String userName, String key){
        return JWT.create()
                .withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .sign(Algorithm.HMAC256(key));
    }
    public static String createRenewToken(String userName, String key){
        return JWT.create()
                .withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*12))
                .sign(Algorithm.HMAC256(key));
    }
    public static String getUserNameFromToken(String token, String key){
        return JWT.require(Algorithm.HMAC256(key))
                .build()
                .verify(token)
                .getSubject();
    }
}
