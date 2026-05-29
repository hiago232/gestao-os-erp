package com.gestaooserp.dev.service;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.PedidoCompraItem;
import com.gestaooserp.dev.repository.PedidoCompraItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoCompraItemService {

    private final PedidoCompraItemRepository pedidoCompraItemRepository;

    @Autowired
    public PedidoCompraItemService(PedidoCompraItemRepository pedidoCompraItemRepository){
        this.pedidoCompraItemRepository = pedidoCompraItemRepository;
    }

    public List<PedidoCompraItem> findAll(){
        List<PedidoCompraItem> pedidoCompraItemList = pedidoCompraItemRepository.findAll();
        return pedidoCompraItemList.stream().map(PedidoCompraItem::new).collect(Collectors.toList());
    }

    public PedidoCompraItem findById(Long id){
        return pedidoCompraItemRepository.findById(id).orElse(null);
    }

    public PedidoCompraItem save(PedidoCompraItem pedidoCompraItem){
        return null; //TODO: implementar DTO
    }

    public PedidoCompraItem update(Long id,PedidoCompraItem pedidoCompraItem){
        if (pedidoCompraItemRepository.findById(id).isPresent()){
            return pedidoCompraItemRepository.save(pedidoCompraItem);
        }
        return null;
    }

    public Boolean delete(Long id){
        PedidoCompraItem pedidoCompraItem = pedidoCompraItemRepository.findById(id).orElse(null);
        if (pedidoCompraItem != null){
            pedidoCompraItemRepository.delete(pedidoCompraItem);
            return true;
        }
        return false;
    }

}
