package tn.esprit.ecommerceespritpi.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import tn.esprit.ecommerceespritpi.Entities.User;

import java.util.Date;

@Component
public class JwtTokenProvider {
    private static final String SECRET_KEY = "your_secret_key is 4e2r58r5t2nn8552z56633zer5987700";
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    public String createToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
