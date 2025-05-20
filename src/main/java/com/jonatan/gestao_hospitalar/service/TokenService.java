package com.jonatan.gestao_hospitalar.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    private static final long EXPIRATION_TIME = 86400000; // 24h

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String gerarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey) // novo formato com objeto Key
                .compact();
    }
}
