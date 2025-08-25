package org.xiaoguang.smartpropertymanagementsystemgb.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    
    // JWT密钥
    private String secret = "smart-property-management-system-secret-key";
    
    // 过期时间(秒) 2小时
    private Long expiration = 7200L;
    
    /**
     * 生成JWT token
     * @param username 用户名
     * @return token
     */
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }
    
    /**
     * 从token中获取用户名
     * @param token token
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }
    
    /**
     * 验证token是否过期
     * @param token token
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }
    
    /**
     * 验证token
     * @param token token
     * @param username 用户名
     * @return 是否有效
     */
    public Boolean validateToken(String token, String username) {
        final String tokenUsername = getUsernameFromToken(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }
    
    /**
     * 从token中获取过期时间
     * @param token token
     * @return 过期时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }
    
    /**
     * 从token中获取claims
     * @param token token
     * @return claims
     */
    private Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    
    /**
     * 创建token
     * @param claims 声明
     * @param subject 主题
     * @return token
     */
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
    /**
     * 获取过期时间(秒)
     * @return 过期时间
     */
    public Long getExpiration() {
        return expiration;
    }
}