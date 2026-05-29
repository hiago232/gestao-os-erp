package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.ClienteFisico;
import com.gestaooserp.dev.service.ClienteFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente/fisico")
public class ClienteFisicoController {

    @Autowired
    ClienteFisicoService clienteFisicoService;

    @GetMapping("/")
    public ResponseEntity<List<ClienteFisico>> getAll(){
        List<ClienteFisico> clienteFisicoList = clienteFisicoService.findAll();
        if (clienteFisicoList != null){
            return new ResponseEntity<>(clienteFisicoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteFisico> getById(@PathVariable Long id){
        ClienteFisico clienteFisico = clienteFisicoService.findById(id);
        if (clienteFisico != null){
            return new ResponseEntity<>(clienteFisico,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<ClienteFisico> create(@RequestBody ClienteFisico clienteFisico){
        return new ResponseEntity<>(clienteFisicoService.save(clienteFisico),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteFisico> update(@PathVariable Long id,@RequestBody ClienteFisico clienteFisico){
        ClienteFisico clienteFisicoAtualizado = clienteFisicoService.update(id,clienteFisico);
        if (clienteFisicoAtualizado != null){
            return new ResponseEntity<>(clienteFisicoAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if(clienteFisicoService.delete(id)){
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
