package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.PedidoCompra;
import com.gestaooserp.dev.service.PedidoCompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

@RestController
@RequestMapping("/pedido-compra")
public class PedidoCompraController {

    private final PedidoCompraService pedidoCompraService;

    public PedidoCompraController(PedidoCompraService pedidoCompraService){
        this.pedidoCompraService = pedidoCompraService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PedidoCompra>> getAll(){
        List<PedidoCompra> pedidoCompraList = pedidoCompraService.findAll();
        if (pedidoCompraList != null){
            return new ResponseEntity<>(pedidoCompraList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoCompra> getById(@PathVariable Long id){
        PedidoCompra pedidoCompra = pedidoCompraService.findById(id);
        if (pedidoCompra != null){
            return new ResponseEntity<>(pedidoCompra,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<PedidoCompra> create(@RequestBody PedidoCompra pedidoCompra){
        return new ResponseEntity<>(pedidoCompraService.save(pedidoCompra),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoCompra> update(@PathVariable Long id,@RequestBody PedidoCompra pedidoCompra){
        PedidoCompra pedidoCompraAtualizado = pedidoCompraService.update(id, pedidoCompra);
        if (pedidoCompraAtualizado != null){
            return new ResponseEntity<>(pedidoCompraAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteExchange("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if (pedidoCompraService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
