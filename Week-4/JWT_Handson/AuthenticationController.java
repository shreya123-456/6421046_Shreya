package com.cognizant.jwt.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@RestController
public class AuthenticationController {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // In real apps, keep in config

    @GetMapping("/authenticate")
    public String authenticate(HttpServletRequest request) {
        // Step 1: Get Authorization header
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        // Step 2: Decode Base64 encoded credentials
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String decodedCredentials = new String(decodedBytes);

        // Step 3: Extract username and password
        String[] parts = decodedCredentials.split(":", 2);
        String username = parts[0];
        String password = parts[1];

        // Step 4: (Optional) Validate credentials manually
        if (!username.equals("user") || !password.equals("pwd")) {
            throw new RuntimeException("Invalid credentials");
        }


        // Step 5: Generate JWT token
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 10 minutes
                .signWith(SECRET_KEY)
                .compact();

        return "{\"token\":\"" + token + "\"}";
    }
}

