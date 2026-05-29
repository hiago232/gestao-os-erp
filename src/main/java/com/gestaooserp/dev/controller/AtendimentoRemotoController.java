package com.gestaooserp.dev.controller;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.AtendimentoRemoto;
import com.gestaooserp.dev.service.AtendimentoRemotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimento-remoto")
public class AtendimentoRemotoController {

    @Autowired
    AtendimentoRemotoService atendimentoRemotoService;

    @GetMapping("/")
    public ResponseEntity<List<AtendimentoRemoto>> getAll(){
        List<AtendimentoRemoto> atendimentoRemotoList = atendimentoRemotoService.findAll();
        if (atendimentoRemotoList != null){
            return new ResponseEntity<>(atendimentoRemotoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoRemoto> getById(@PathVariable Long id){
        AtendimentoRemoto atendimentoRemoto = atendimentoRemotoService.findById(id);
        if (atendimentoRemoto != null){
            return new ResponseEntity<>(atendimentoRemoto,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<AtendimentoRemoto> create(@RequestBody AtendimentoRemoto atendimentoRemoto){
        return new ResponseEntity<>(atendimentoRemotoService.save(atendimentoRemoto),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtendimentoRemoto> update(@PathVariable Long id,@RequestBody AtendimentoRemoto atendimentoRemoto){
        AtendimentoRemoto atendimentoRemotoAtualizado = atendimentoRemotoService.update(id,atendimentoRemoto);
        if(atendimentoRemotoAtualizado != null){
            return new ResponseEntity<>(atendimentoRemotoAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if(atendimentoRemotoService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}
