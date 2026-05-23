package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.ManutencaoItem;
import com.gestaooserp.dev.repository.ManutencaoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManutencaoItemService {

    private final ManutencaoItemRepository manutencaoItemRepository;

    @Autowired
    public ManutencaoItemService(ManutencaoItemRepository manutencaoItemRepository){
        this.manutencaoItemRepository = manutencaoItemRepository;
    }

    public List<ManutencaoItem> findAll(){
        List<ManutencaoItem> manutencaoItemList = manutencaoItemRepository.findAll();
        return manutencaoItemList.stream().map(ManutencaoItem::new).collect(Collectors.toList());
    }

    public ManutencaoItem findById(Long id){
        return manutencaoItemRepository.findById(id).orElse(null);
    }

    public ManutencaoItem save(ManutencaoItem manutencaoItem){
        return null; //TODO: Implementar DTO
    }

    public ManutencaoItem update(Long id,ManutencaoItem manutencaoItem){
        if (manutencaoItemRepository.findById(id).isPresent()){
            manutencaoItemRepository.save(manutencaoItem);
        }
        return null;
    }

    public Boolean delete(Long id){
        ManutencaoItem manutencaoItem =  manutencaoItemRepository.findById(id).orElse(null);
        if (manutencaoItem != null){
            manutencaoItemRepository.delete(manutencaoItem);
            return true;
        }
        return false;

    }
}
