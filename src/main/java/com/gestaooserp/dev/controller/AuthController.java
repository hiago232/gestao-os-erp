package com.gestaooserp.dev.controller;


import com.gestaooserp.dev.dto.security.AccountCredentialDTO;
import com.gestaooserp.dev.dto.security.TokenDTO;
import com.gestaooserp.dev.exception.InvalidJwtAuthException;
import com.gestaooserp.dev.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/signin")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("")
    public ResponseEntity<?> signIn(@RequestBody AccountCredentialDTO credentials){
        if (isValidCredential(credentials)) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Credencial inválida!");
        TokenDTO token = service.signIn(credentials).getBody();
        if(token == null) ResponseEntity.status(HttpStatus.FORBIDDEN).body("Requisição inválida");
        return ResponseEntity.ok(token);
    }

    private static boolean isValidCredential(AccountCredentialDTO credentials) {
        return credentials == null ||
                StringUtils.isBlank(credentials.getPassword()) ||
                StringUtils.isBlank(credentials.getUserName());
    }
}
