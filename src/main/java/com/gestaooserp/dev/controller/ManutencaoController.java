package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.Manutencao;
import com.gestaooserp.dev.service.ManutencaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {

    private final ManutencaoService manutencaoService;

    public ManutencaoController(ManutencaoService manutencaoService){
        this.manutencaoService = manutencaoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Manutencao>> getAll(){
        List<Manutencao> manutencaoList = manutencaoService.findAll();
        if (manutencaoList != null){
            return new ResponseEntity<>(manutencaoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> getById(@PathVariable Long id){
        Manutencao manutencao = manutencaoService.findById(id);
        if (manutencao != null){
            return new ResponseEntity<>(manutencao,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Manutencao> create(@RequestBody Manutencao manutencao){
        return new ResponseEntity<>(manutencaoService.save(manutencao),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> update(@PathVariable Long id,@RequestBody Manutencao manutencao){
        Manutencao manutencaoAtualizada = manutencaoService.update(id, manutencao);
        if (manutencaoAtualizada != null){
            return new ResponseEntity<>(manutencaoAtualizada,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteExchange("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if (manutencaoService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}