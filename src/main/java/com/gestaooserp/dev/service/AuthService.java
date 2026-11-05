package com.gestaooserp.dev.service;


import com.gestaooserp.dev.dto.security.AccountCredentialDTO;
import com.gestaooserp.dev.dto.security.TokenDTO;
import com.gestaooserp.dev.entity.Users;
import com.gestaooserp.dev.exception.ResourceNotFoundException;
import com.gestaooserp.dev.repository.UsersRepository;
import com.gestaooserp.dev.security.jwt.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;


@Service
public class AuthService {

    Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UsersRepository repository;

    public ResponseEntity<TokenDTO> signIn(@RequestBody AccountCredentialDTO credentials) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.getUserName(),
                        credentials.getPassword()
                )
        );

        var user = repository.findByUserName(credentials.getUserName());
        if (user == null) {
            throw new UsernameNotFoundException("Username " + credentials.getUserName() + " not found!");
        }

        var token = tokenProvider.createAccessToken(
                credentials.getUserName(),
                user.getRoles()
        );
        return ResponseEntity.ok(token);
    }

//    public ResponseEntity<TokenDTO> refreshToken(String username, String refreshToken) {
//        var user = repository.findByUserName(username);
//        TokenDTO token;
//        if (user != null) {
//            token = tokenProvider.refreshToken(refreshToken);
//        } else {
//            throw new UsernameNotFoundException("Username " + username + " not found!");
//        }
//        return ResponseEntity.ok(token);
//    }

    public AccountCredentialDTO create(AccountCredentialDTO user) {

        if (user == null) throw new ResourceNotFoundException("null credentials detail");

        logger.info("Creating one new User!");
        var entity = new Users();
        entity.setUserName(user.getUserName());
        entity.setPassword(generateHashedPassword(user.getPassword()));
        entity.setAccountNonExpired(true);
        entity.setAccountNonLocked(true);
        entity.setCredentialsNonExpired(true);
        entity.setEnabled(true);

        var dto = repository.save(entity);
        return new AccountCredentialDTO(dto.getUsername(), dto.getPassword());
    }

    private String generateHashedPassword(String password) {

        PasswordEncoder pbkdf2Encoder = new Pbkdf2PasswordEncoder(
                "", 8, 185000,
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("pbkdf2", pbkdf2Encoder);
        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);

        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
        return passwordEncoder.encode(password);
    }


}