package com.julio.auth_microservice.auth;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecretKeyBuilder;
import io.jsonwebtoken.security.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private final String JWT_SECRET = "TODO:needs_env";
    private final Long JWT_EXPIRATION_MINUTES = 5L;
    private final Long JWT_EXPIRATION_MS = JWT_EXPIRATION_MINUTES*(60)*(1000);

    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_MS))
                .signWith(getSignatureKey())
                .compact();
    }

    public String getUserNameFromToken(String token){
        return Jwts.parser().verifyWith((SecretKey) getSignatureKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    private Key getSignatureKey(){
        return Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().verifyWith((SecretKey) getSignatureKey()).build().parseSignedClaims(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
