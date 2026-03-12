package com.example.practicanro01.security;
import io.jsonwebtoken.*;import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Component;import java.util.Date;
@Component public class JwtUtil { @Value("${jwt.secret}") private String secret; @Value("${jwt.expiration}") private long expiration;
    public String generateToken(String username) { Date now = new Date(); Date exp = new Date(now.getTime()+expiration); return Jwts.builder().setSubject(username).setIssuedAt(now).setExpiration(exp).signWith(SignatureAlgorithm.HS256, secret).compact(); }
    public String extractUsername(String token) { return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject(); }
    public boolean validateToken(String token) { try { return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration().after(new Date()); } catch(Exception e) { return false; } }
}
