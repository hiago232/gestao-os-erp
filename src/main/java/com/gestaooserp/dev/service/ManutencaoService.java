package com.gestaooserp.dev.service;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */
import com.gestaooserp.dev.entity.Manutencao;
import com.gestaooserp.dev.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManutencaoService {

    private final ManutencaoRepository manutencaoRepository;

    @Autowired
    public ManutencaoService(ManutencaoRepository manutencaoRepository){
        this.manutencaoRepository = manutencaoRepository;
    }

    public List<Manutencao> findAll(){
        List<Manutencao> manutencaoList = manutencaoRepository.findAll();
        return manutencaoList.stream().map(Manutencao::new).collect(Collectors.toList());
    }

    public Manutencao findById(Long id){
        return manutencaoRepository.findById(id).orElse(null);
    }

    public Manutencao save(Manutencao manutencao){
        return null; //TODO: implentar DTO
    }

    public Manutencao update(Long id,Manutencao manutencao){
        if (manutencaoRepository.findById(id).isPresent()){
            return manutencaoRepository.save(manutencao);
        }
        return null;
    }

    public Boolean delete(Long id){
        Manutencao manutencao = manutencaoRepository.findById(id).orElse(null);
        if (manutencao != null){
            manutencaoRepository.delete(manutencao);
            return true;
        }
        return false;
    }
}
