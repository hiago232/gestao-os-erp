package com.gestaooserp.dev.dto.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCredentialDTO {

    private String userName;
    private String password;

    public AccountCredentialDTO() {
    }

    public AccountCredentialDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
