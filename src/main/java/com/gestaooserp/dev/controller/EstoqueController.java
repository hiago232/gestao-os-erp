package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.Estoque;
import com.gestaooserp.dev.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService){
        this.estoqueService = estoqueService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Estoque>> getAll(){
        List<Estoque> estoqueList = estoqueService.findAll();
        if (estoqueList != null){
            return new ResponseEntity<>(estoqueList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getById(@PathVariable Long id){
        Estoque estoque = estoqueService.findById(id);
        if (estoque != null){
            return new ResponseEntity<>(estoque,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Estoque> create(@RequestBody Estoque estoque){
        return new ResponseEntity<>(estoqueService.save(estoque),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> update(@PathVariable Long id,@RequestBody Estoque estoque){
        Estoque estoqueAtualizado = estoqueService.update(id,estoque);
        if (estoqueAtualizado != null){
            return new ResponseEntity<>(estoqueAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if (estoqueService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
