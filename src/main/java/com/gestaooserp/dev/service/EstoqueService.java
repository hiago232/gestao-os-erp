package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.Estoque;
import com.gestaooserp.dev.repository.EstoqueRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    @Autowired
    public EstoqueService(EstoqueRepository estoqueRepository){
        this.estoqueRepository = estoqueRepository;
    }

    public List<Estoque> findAll(){
        List<Estoque> estoqueList = estoqueRepository.findAll();
        return estoqueList.stream().map(Estoque::new).collect(Collectors.toList());
    }

    public Estoque findById(Long id){
        return estoqueRepository.findById(id).orElse(null);
    }

    public Estoque save(Estoque estoque){
        return null; //TODO: implentar DTO
    }

    public Estoque update(Long id,Estoque estoque){
        if (estoqueRepository.findById(id).isPresent()){
            return estoqueRepository.save(estoque);
        }
        return null;
    }

    public Boolean delete(Long id){
        Estoque estoque = estoqueRepository.findById(id).orElse(null);
        if(estoque != null){
            estoqueRepository.delete(estoque);
            return true;
        }
        return false;
    }
}
