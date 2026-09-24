package com.gestaooserp.dev.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    @Getter
    @Setter
    private Long id;

    @Column(name = "user_name", unique = true)
    @Getter
    @Setter
    private String userName;

    @Column
    @Getter
    @Setter
    private String email;

    @Column
    @Setter
    private String password;

    @Column(name = "account_non_expired")
    @Getter
    @Setter
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked")
    @Getter
    @Setter
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    @Getter
    @Setter
    private Boolean credentialsNonExpired;

    @Column
    @Getter
    @Setter
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission",
        joinColumns = {@JoinColumn(name = "id_user")},
        inverseJoinColumns =  {@JoinColumn(name = "id_permission")}
    )
    @Getter
    @Setter
    private List<Permission> permissionList;

    public Users(){}

    public List<String> getRoles(){
        List<String> roles = new ArrayList<>();
        for(Permission permission: permissionList){
            roles.add(permission.getDescription());
        }
        return roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissionList;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
