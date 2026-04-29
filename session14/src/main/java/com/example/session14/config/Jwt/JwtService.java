package com.example.session14.config.Jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtService {
//    lấy thuộc tính từ properties
    @Value("${jwt.secret-key}")
    private String jwtSecret;
    @Value("${jwt.expired}")
    private long expiredTime;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

//    sinh jwt
    public String generateAccessToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
//                .setPayload(userDetails)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiredTime))
                .signWith(getKey())
                .compact();
    }
    public String generateRefreshToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
//                .setPayload(userDetails)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiredTime*96*7))
                .signWith(getKey())
                .compact();
    }

//    xác minh token hợp lệ
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);

            return true;

        } catch (ExpiredJwtException e) {
            System.out.println("Token hết hạn");
        } catch (UnsupportedJwtException e) {
            System.out.println("Token không được hỗ trợ");
        } catch (MalformedJwtException e) {
            System.out.println("Token không đúng định dạng");
        } catch (SignatureException e) {
            System.out.println("Chữ ký không hợp lệ (sai secret key)");
        } catch (IllegalArgumentException e) {
            System.out.println("Token rỗng hoặc null");
        }

        return false;
    }

//    giải mã token
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token).getBody().getSubject();
    }
}
