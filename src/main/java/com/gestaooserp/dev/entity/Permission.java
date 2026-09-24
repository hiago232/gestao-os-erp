package com.gestaooserp.dev.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(length = 20)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String description;

    public Permission(){}

    @Override
    public String getAuthority() {
        return this.description;
    }
}
