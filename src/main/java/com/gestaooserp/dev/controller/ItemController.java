package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.Item;
import com.gestaooserp.dev.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Item>> getAll(){
        List<Item> itemList = itemService.findAll();
        if (itemList != null){
            return new ResponseEntity<>(itemList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable Long id){
        Item item = itemService.findById(id);
        if (item != null){
            return new ResponseEntity<>(item,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Item> create(@RequestBody Item item){
        return new ResponseEntity<>(itemService.save(item),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id,@RequestBody Item item){
        Item itemAtualizado = itemService.update(id,item);
        if (itemAtualizado != null){
            return new ResponseEntity<>(itemAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id) {
        if (itemService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
