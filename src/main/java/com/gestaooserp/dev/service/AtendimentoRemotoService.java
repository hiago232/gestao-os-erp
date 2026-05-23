package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.AtendimentoRemoto;
import com.gestaooserp.dev.repository.AtendimentoRemotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtendimentoRemotoService {

    private final AtendimentoRemotoRepository atendimentoRemotoRepository;

    @Autowired
    public AtendimentoRemotoService(AtendimentoRemotoRepository atendimentoRemotoRepository){
        this.atendimentoRemotoRepository = atendimentoRemotoRepository;
    }

    public List<AtendimentoRemoto> findAll(){
        List<AtendimentoRemoto> atendimentoRemotoList = atendimentoRemotoRepository.findAll();
        return atendimentoRemotoList.stream().map(AtendimentoRemoto::new).collect(Collectors.toList());
    }

    public AtendimentoRemoto findById(Long id){
        return atendimentoRemotoRepository.findById(id).orElse(null);
    }

    public AtendimentoRemoto save(AtendimentoRemoto atendimentoRemoto){
        return null; //TODO: implentar DTO
    }

    public AtendimentoRemoto update(Long id, AtendimentoRemoto atendimentoRemoto){
        if(atendimentoRemotoRepository.findById(id).isPresent()){
            return atendimentoRemotoRepository.save(atendimentoRemoto);
        }
        return null;
    }

    public Boolean delete(Long id){
        AtendimentoRemoto atendimentoRemoto = atendimentoRemotoRepository.findById(id).orElse(null);
        if(atendimentoRemoto != null){
            atendimentoRemotoRepository.delete(atendimentoRemoto);
            return true;
        }
        return false;
    }
}
