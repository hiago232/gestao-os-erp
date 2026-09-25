package com.gestaooserp.dev.service;

import com.gestaooserp.dev.entity.Users;
import com.gestaooserp.dev.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsersService implements UserDetailsService {

    UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUserName(username);
        if(user != null) return user;
        else throw new UsernameNotFoundException("Usuário "+username+" não encontrado");
    }
}
