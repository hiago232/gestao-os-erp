package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.Fabricante;
import com.gestaooserp.dev.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricanteService {

    private final FabricanteRepository fabricanteRepository;

    @Autowired
    public FabricanteService(FabricanteRepository fabricanteRepository){
        this.fabricanteRepository = fabricanteRepository;
    }

    public List<Fabricante> findAll(){
        List<Fabricante> fabricanteList = fabricanteRepository.findAll();
        return fabricanteList.stream().map(Fabricante::new).collect(Collectors.toList());
    }

    public Fabricante findById(Long id){
        return fabricanteRepository.findById(id).orElse(null);
    }

    public Fabricante save(Fabricante fabricante){
        return null;
    }

    public Fabricante update(Long id,Fabricante fabricante){
        if (fabricanteRepository.findById(id).isPresent()){
            return fabricanteRepository.save(fabricante);
        }
        return null;
    }

    public Boolean delete(Long id){
        Fabricante fabricante = fabricanteRepository.findById(id).orElse(null);
        if (fabricante != null){
            fabricanteRepository.delete(fabricante);
            return true;
        }
        return false;
    }
}
