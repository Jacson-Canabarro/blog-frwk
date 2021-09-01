package br.com.frwk.security;

import br.com.frwk.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@SuppressWarnings("java:S1874")
public class TokenService {

    @Value("${blog.jwt.expiration}")
    private String expiration;

    @Value("${blog.jtw.secret}")
    private String secret;

    public String generateToken(Authentication authenticate) {
        User user = (User) authenticate.getPrincipal();
        Date now = new Date();
        Date expirationTime = new Date(now.getTime()+ Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("blog_frw API")
                .setSubject(user.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public UUID getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return UUID.fromString(claims.getSubject());
    }
}
