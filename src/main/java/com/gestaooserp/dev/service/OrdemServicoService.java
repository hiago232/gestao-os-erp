package com.gestaooserp.dev.service;


/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.OrdemServico;
import com.gestaooserp.dev.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return ordemServicoRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    public OrdemServico saveOrdemServico(OrdemServico ordemServico){
        return null; //TODO: implentar DTO
    }

    public OrdemServico updateOrdemServico(Long id,OrdemServico ordemServico){
        if (ordemServicoRepository.findById(Math.toIntExact(id)).isPresent()) {
            return ordemServicoRepository.save(ordemServico);
        }else{
            return null;
        }
    }

    public Boolean deleteOrdemServico(Long id){
        OrdemServico ordemServico = ordemServicoRepository.findById(Math.toIntExact(id)).orElse(null);
        if(ordemServico != null){
            ordemServicoRepository.delete(ordemServico);
            return true;
        }else{
            return false;
        }
    }
}
