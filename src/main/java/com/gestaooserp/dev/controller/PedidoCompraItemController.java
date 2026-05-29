package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.PedidoCompraItem;
import com.gestaooserp.dev.service.PedidoCompraItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido-compra/item")
public class PedidoCompraItemController {

    private final PedidoCompraItemService pedidoCompraItemService;

    public PedidoCompraItemController(PedidoCompraItemService pedidoCompraItemService){
        this.pedidoCompraItemService = pedidoCompraItemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PedidoCompraItem>> getAll(){
        List<PedidoCompraItem> pedidoCompraItemList = pedidoCompraItemService.findAll();
        if (pedidoCompraItemList != null){
            return new ResponseEntity<>(pedidoCompraItemList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoCompraItem> getById(@PathVariable Long id){
        PedidoCompraItem pedidoCompraItem = pedidoCompraItemService.findById(id);
        if (pedidoCompraItem != null){
            return new ResponseEntity<>(pedidoCompraItem,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<PedidoCompraItem> create(@RequestBody PedidoCompraItem pedidoCompraItem){
        return new ResponseEntity<>(pedidoCompraItemService.save(pedidoCompraItem),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoCompraItem> update(@PathVariable Long id,@RequestBody PedidoCompraItem pedidoCompraItem){
        PedidoCompraItem pedidoCompraItemAtualizado = pedidoCompraItemService.update(id,pedidoCompraItem);
        if (pedidoCompraItemAtualizado != null){
            return new ResponseEntity<>(pedidoCompraItemAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if (pedidoCompraItemService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}
