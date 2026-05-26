package com.gestaooserp.dev.service;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.PedidoCompra;
import com.gestaooserp.dev.repository.PedidoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoCompraService {

    private final PedidoCompraRepository pedidoCompraRepository;

    @Autowired
    public PedidoCompraService(PedidoCompraRepository pedidoCompraRepository){
        this.pedidoCompraRepository = pedidoCompraRepository;
    }

    public List<PedidoCompra> findAll(){
        List<PedidoCompra> pedidoCompraList = pedidoCompraRepository.findAll();
        return pedidoCompraList.stream().map(PedidoCompra::new).collect(Collectors.toList());
    }

    public PedidoCompra findById(Long id){
        return pedidoCompraRepository.findById(id).orElse(null);
    }

    public PedidoCompra save(PedidoCompra pedidoCompra){
        return null; //TODO: implementar DTO
    }

    public PedidoCompra update(Long id,PedidoCompra pedidoCompra){
        if (pedidoCompraRepository.findById(id).isPresent()){
            return pedidoCompraRepository.save(pedidoCompra);
        }
        return null;
    }

    public Boolean delete(Long id){
        PedidoCompra pedidoCompra = pedidoCompraRepository.findById(id).orElse(null);
        if (pedidoCompra != null){
            pedidoCompraRepository.delete(pedidoCompra);
            return true;
        }
        return false;
    }
}
