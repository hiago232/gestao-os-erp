package com.gestaooserp.dev.security.jwt;


import com.gestaooserp.dev.dto.security.TokenDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwtTokenProvider {

    @Value("${api.security.token.secret}")
    private String secretKey;

    @Value("${api.security.token.expire-lengh}")
    private Long validityMillieSeconds;

    @Autowired
    private UserDetailsService userDetailsService;

    private Algorithm algorithm;

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        algorithm = Algorithm.HMAC256(secretKey.getBytes());
    }

    public TokenDTO createAccessToken(String username, List<String> roles){
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityMillieSeconds );
        String accessToken = getAccessToken(username, roles, now, validity);
        String refreshToken = getRefreshToken(username, roles, now);
        return new TokenDTO(username,true,now,validity,accessToken,refreshToken);
    }

    private String getRefreshToken(String username, List<String> roles, Date now) {
        return "";
    }

    private String getAccessToken(String username, List<String> roles, Date now, Date validity) {
        return "";
    }
}
