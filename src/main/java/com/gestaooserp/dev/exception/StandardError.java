package com.gestaooserp.dev.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StandardError {


    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

    public StandardError(){}

    public StandardError(LocalDateTime timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }
}
