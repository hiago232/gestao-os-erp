package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.ManutencaoItem;
import com.gestaooserp.dev.service.ManutencaoItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manutencao/item")
public class ManutencaoItemController {

    private final ManutencaoItemService manutencaoItemService;

    public ManutencaoItemController(ManutencaoItemService manutencaoItemService){
        this.manutencaoItemService = manutencaoItemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ManutencaoItem>> getAll(){
        List<ManutencaoItem> manutencaoItemList = manutencaoItemService.findAll();
        if (manutencaoItemList != null){
            return new ResponseEntity<>(manutencaoItemList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManutencaoItem> getById(@PathVariable Long id){
        ManutencaoItem manutencaoItem = manutencaoItemService.findById(id);
        if (manutencaoItem != null){
            return  new ResponseEntity<>(manutencaoItem,HttpStatus.OK);
        }
        return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<ManutencaoItem> create(@RequestBody ManutencaoItem manutencaoItem){
        return new ResponseEntity<>(manutencaoItemService.save(manutencaoItem),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManutencaoItem> update(@PathVariable Long id,@RequestBody ManutencaoItem manutencaoItem){
        ManutencaoItem manutencaoItemAtualizada = manutencaoItemService.update(id,manutencaoItem);
        if (manutencaoItemAtualizada != null){
            return new ResponseEntity<>(manutencaoItemAtualizada,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if (manutencaoItemService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
