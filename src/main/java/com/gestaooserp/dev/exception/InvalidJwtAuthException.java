package com.gestaooserp.dev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthException extends AuthenticationException {
    public InvalidJwtAuthException(String msg) {
        super(msg);
    }
}
