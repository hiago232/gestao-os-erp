package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.Equipamento;
import com.gestaooserp.dev.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService){
        this.equipamentoService = equipamentoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Equipamento>> getAll(){
        List<Equipamento> equipamentoList = equipamentoService.findAll();
        if (equipamentoList != null){
            return new ResponseEntity<>(equipamentoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> getById(@PathVariable Long id){
        Equipamento equipamento = equipamentoService.findById(id);
        if (equipamento != null){
            return new ResponseEntity<>(equipamento,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Equipamento> create(@RequestBody Equipamento equipamento){
        return new ResponseEntity<>(equipamentoService.save(equipamento),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> update(@PathVariable Long id,@RequestBody Equipamento equipamento){
        Equipamento equipamentoAtualizado = equipamentoService.update(id,equipamento);
        if (equipamentoAtualizado != null){
            return new ResponseEntity<>(equipamentoAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if(equipamentoService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
