package com.animalCommunity.project.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.signing.key}")
    private String signingKey ;

    public String createToken(int userUid, String role, Long expriedMs){

        // Keys.hmacShaKeyFor : hmac알고리즘을 이용하여 키 생성
        // signingKey.getBytes :getBytes는 String클래스의 메서드중 하나로 byte 배열로 변환해줌
        // StandardCharsets.UTF_8 : UTF_8로 변환?
        SecretKey key = Keys.hmacShaKeyFor((signingKey.getBytes(StandardCharsets.UTF_8)));

        return Jwts.builder()
                .claim("userUid", userUid)
                .claim("role", role)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expriedMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    // token에서 role 꺼내오기
    public String getRole(String token){
        SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token.substring("Bearer ".length()))
                .getBody()
                .get("role", String.class);
    }

    //token에서 userUid 가지고 오기
    public int getUserUid (String token){
        SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token.substring("Bearer ".length()))
                .getBody()
                .get("userUid", Integer.class);
    }

    //토큰이 유효한지 확인하기
    public boolean isExpired(String token){
        SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token.substring("Bearer ".length()))
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
