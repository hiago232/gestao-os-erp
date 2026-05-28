package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */


import com.gestaooserp.dev.entity.OrdemServico;
import com.gestaooserp.dev.service.OrdemServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService){
        this.ordemServicoService = ordemServicoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<OrdemServico>> getAll(){
        List<OrdemServico> ordemServicoList = ordemServicoService.findAll();
        if (ordemServicoList != null){
            return new ResponseEntity<>(ordemServicoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> getById(@PathVariable Long id){
        OrdemServico ordemServico = ordemServicoService.findById(id);
        if (ordemServico != null){
            return new ResponseEntity<>(ordemServico,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<OrdemServico> create(@RequestBody OrdemServico ordemServico){
        return new ResponseEntity<>(ordemServicoService.save(ordemServico),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> update(@PathVariable Long id,@RequestBody OrdemServico ordemServico){
        OrdemServico manutencaoAtualizada = ordemServicoService.update(id, ordemServico);
        if (manutencaoAtualizada != null){
            return new ResponseEntity<>(manutencaoAtualizada,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteExchange("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if (ordemServicoService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
