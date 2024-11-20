package com.ssafy.edu.jwt.util;

import java.util.Date;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

  private final String SECRET_KEY =
      "DMoMJOGwHfUj/2x791wwbtXozdxwl/cvwft6sefzuNlzB8NRTRfzgQl0/tm9SHlFLalUUwmtrWa41U33H/pTEQ==\r\n";
  private final long EXPIRATION_TIME = 1000 * 60 * 60; // 3 in milliseconds

  // Generate Token
  public String generateToken(Long userId) {
    return Jwts.builder().setSubject(String.valueOf(userId)).setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
  }

  // Validate Token
  public boolean validateToken(String token) {
    try {
      Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

      if (claims.getExpiration().before(new Date())) {
        return false; // 토큰이 만료됨
      }
      return true;
    } catch (JwtException | IllegalArgumentException e) {
      return false;
    }
  }

  // Extract User ID from Token
  public Long getUserIdFromToken(String token) {
    Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    return Long.parseLong(claims.getSubject());
  }
}
