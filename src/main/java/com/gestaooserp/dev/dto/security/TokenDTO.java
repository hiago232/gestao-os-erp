package com.gestaooserp.dev.dto.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class TokenDTO {

    private String userName;
    private String password;
    private Boolean authenticated;
    private Date created;
    private Date expiration;
    private String accessToken;
    private String refreshToken;

    public TokenDTO() {

    }

    public TokenDTO(String userName, String password, Boolean authenticated, Date created, Date expiration, String accessToken, String refreshToken) {
        this.userName = userName;
        this.password = password;
        this.authenticated = authenticated;
        this.created = created;
        this.expiration = expiration;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
