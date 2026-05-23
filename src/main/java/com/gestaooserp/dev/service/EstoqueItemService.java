package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.EstoqueItem;
import com.gestaooserp.dev.repository.EstoqueItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueItemService {

    private final EstoqueItemRepository estoqueItemRepository;

    @Autowired
    public EstoqueItemService(EstoqueItemRepository estoqueItemRepository){
        this.estoqueItemRepository = estoqueItemRepository;
    }

    public List<EstoqueItem> findAll(){
        List<EstoqueItem> estoqueItemList = estoqueItemRepository.findAll();
        return estoqueItemList.stream().map(EstoqueItem::new).collect(Collectors.toList());
    }

    public EstoqueItem findById(Long id){
        return estoqueItemRepository.findById(id).orElse(null);
    }

    public EstoqueItem save(EstoqueItem estoqueItem){
        return null;
    }

    public EstoqueItem update (Long id,EstoqueItem estoqueItem){
        if (estoqueItemRepository.findById(id).isPresent()){
            return estoqueItemRepository.save(estoqueItem);
        }
        return null;
    }

    public Boolean delete(Long id){
        EstoqueItem estoqueItem = estoqueItemRepository.findById(id).orElse(null);
        if (estoqueItem != null){
            estoqueItemRepository.delete(estoqueItem);
            return true;
        }
        return false;
    }
}
