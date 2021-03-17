package kr.co.fastcampus.eatgo.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;


public class JwtUtil {


    private Key Key;



    public JwtUtil(String secret){
        this.Key= Keys.hmacShaKeyFor(secret.getBytes());

    }

    public String createToken(Long userId, String name) {
        JwtBuilder builder = Jwts.builder()
                .claim("userId", userId)
                .claim("name", name);

        return builder
                .signWith(Key, SignatureAlgorithm.HS256)
                .compact();
    }


    public Claims getClamis(String token){
        return Jwts.parser()
                .setSigningKey(Key)
                .parseClaimsJws(token)
                .getBody();
    }
}
