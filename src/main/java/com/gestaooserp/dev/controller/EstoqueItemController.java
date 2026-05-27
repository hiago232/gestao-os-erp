package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.EstoqueItem;
import com.gestaooserp.dev.service.EstoqueItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque/item")
public class EstoqueItemController {

    private final EstoqueItemService estoqueItemService;

    public EstoqueItemController(EstoqueItemService estoqueItemService){
        this.estoqueItemService = estoqueItemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<EstoqueItem>> getAll(){
        List<EstoqueItem> estoqueItemList = estoqueItemService.findAll();
        if (estoqueItemList != null){
            return new ResponseEntity<>(estoqueItemList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueItem> getById(@PathVariable Long id){
        EstoqueItem estoqueItem = estoqueItemService.findById(id);
        if (estoqueItem != null){
            return new ResponseEntity<>(estoqueItem,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<EstoqueItem> create(@RequestBody EstoqueItem estoqueItem){
        return new ResponseEntity<>(estoqueItemService.save(estoqueItem),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstoqueItem> update(@PathVariable Long id){
        EstoqueItem estoqueItemAtualizado = estoqueItemService.findById(id);
        if (estoqueItemAtualizado != null){
            return new ResponseEntity<>(estoqueItemAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if (estoqueItemService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
