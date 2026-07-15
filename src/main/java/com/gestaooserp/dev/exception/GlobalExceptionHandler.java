package com.gestaooserp.dev.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest request){

            StandardError error = new StandardError(
                    LocalDateTime.now(),
                    HttpStatus.NOT_FOUND.value(),
                    ex.getMessage(),
                    request.getRequestURI()
            );

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
}
