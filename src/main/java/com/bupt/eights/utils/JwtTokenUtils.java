package com.bupt.eights.utils;

import com.bupt.eights.model.AuthorityRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtils {
    
    // expiration time set to 3600s (1 hour)
    private static final long EXPIRATION = 3600L;
    
    // expiration time set to 7 days after select remember me
    private static final long EXPIRATION_REMEMBER = 604800L;
    
    private static final String SECRET = "eightsjwtsecret";
    
    private static final String ISSUER = "com.bupt.eights";
    
    private static final String ROLE_CLAIMS = "role";
    
    public static String createToken(String userName, AuthorityRole role, Boolean isRememberMe) {
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        Map<String, Object> claimMap = new HashMap<>();
        claimMap.put(ROLE_CLAIMS, role);
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET).setClaims(claimMap).setIssuer(ISSUER)
                .setSubject(userName).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000)).compact();
    }
    
    public static String getUserName(String token) {
        return getTokenBody(token).getSubject();
    }
    
    public static AuthorityRole getUserRole(String token) {
        return (AuthorityRole) getTokenBody(token).get(ROLE_CLAIMS);
    }
    
    public static boolean isExpired(String token) {
        try {
            return getTokenBody(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }
    
    private static Claims getTokenBody(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }
}
