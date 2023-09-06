package com.moon.moonblogserver.common;

import com.moon.moonblogserver.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtManager {
    private final String securityKey = "jwtSecret"; // TODO 민감정보는 따로 분리하는 것이 좋다
    private final Long accExpiredTime = 1000 * 60L * 15L ; // 유효시간 15분
    private final Long refExpiredTime = 1000 * 60L * 60L * 24L ; // 유효시간 24시간


    public String generateJwtAccessToken(User user) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(user.getEmail()) // 보통 username
                .setHeader(createHeader())
                .setClaims(createClaims(user)) // 클레임, 토큰에 포함될 정보
                .setExpiration(new Date(now.getTime() + accExpiredTime)) // 만료일
                .signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();
    }
    public String generateJwtRefreshToken(User user) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(user.getEmail()) // 보통 username
                .setHeader(createHeader())
                .setClaims(createClaims(user)) // 클레임, 토큰에 포함될 정보
                .setExpiration(new Date(now.getTime() + refExpiredTime)) // 만료일
                .signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();
    }

    private Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256"); // 해시 256 사용하여 암호화
        header.put("regDate", System.currentTimeMillis());
        return header;
    }

    private Map<String, Object> createClaims(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("loginType", user.getLoginType());
        return claims;
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody();
    }

    public String getEmailFromToken(String token) {
        return (String) getClaims(token).get("email");
    }

    public String getLoginTypeFromToken(String token) {
        return (String) getClaims(token).get("loginType");
    }
//    public Set<MemberRole> getMemberRoleSetFromToken(String token) {
//        return (Set<MemberRole>) getClaims(token).get("roles");
//    }
}
