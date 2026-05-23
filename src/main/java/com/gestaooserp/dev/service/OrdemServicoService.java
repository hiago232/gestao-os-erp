package com.gestaooserp.dev.service;


import com.gestaooserp.dev.entity.OrdemServico;
import com.gestaooserp.dev.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;

    @Autowired
    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository){
        this.ordemServicoRepository = ordemServicoRepository;
    }

    public List<OrdemServico> findAll(){
        List<OrdemServico> ordemServicoList = ordemServicoRepository.findAll();
        return ordemServicoList.stream().map(OrdemServico::new).collect(Collectors.toList());
    }

    public OrdemServico findById(Long id){
        return ordemServicoRepository.findById(id).orElse(null);
    }

    public OrdemServico save(OrdemServico ordemServico){
        return null; //TODO: implentar DTO
    }

    public OrdemServico update(Long id,OrdemServico ordemServico){
        if (ordemServicoRepository.findById(id).isPresent()) {
            return ordemServicoRepository.save(ordemServico);
        }
        return null;
    }

    public Boolean delete(Long id){
        OrdemServico ordemServico = ordemServicoRepository.findById(id).orElse(null);
        if(ordemServico != null){
            ordemServicoRepository.delete(ordemServico);
            return true;
        }
        return false;

    }
}
