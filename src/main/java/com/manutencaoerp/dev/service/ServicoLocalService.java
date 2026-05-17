package com.manutencaoerp.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutencaoerp.dev.entity.ServicoLocal;
import com.manutencaoerp.dev.repository.ServicoLocalRepository;

@Service
public class ServicoLocalService {
    
    // private final ServicoLocalRepository servicoLocalRepository;

    // @Autowired
    // public ServicoLocalService(){}

    @Autowired
    private ServicoLocalRepository servicoLocalRepository;


    public List<ServicoLocal> findAll(){
        return null;
    }

    public ServicoLocal finById(Long id){
        return servicoLocalRepository.findById(id).orElse(null);}

}
