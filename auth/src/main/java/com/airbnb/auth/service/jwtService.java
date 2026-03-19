package com.airbnb.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class jwtService {

    public static String SECRET = "91P4fnoBTGNWMdo48gXgOvMeoLChuMVOSjUBxTQMRSY";

    public void validateToken(final String token){
    Jwts.parser()
            .verifyWith(getSignKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    public String generateToken(String email){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, email);
    }

    public String createToken(Map<String, Object> claims, String email){
        return Jwts.builder()
                .claims(claims)
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 *30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

