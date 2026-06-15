package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Refatorar codigo após Implementar Exception Handler
 */


import com.gestaooserp.dev.dto.request.ManutencaoRequestDTO;
import com.gestaooserp.dev.dto.response.ManutencaoResponseDTO;
import com.gestaooserp.dev.entity.Manutencao;
import com.gestaooserp.dev.service.ManutencaoService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<ManutencaoResponseDTO>> getAll(){
        List<ManutencaoResponseDTO> manutencaoList = manutencaoService.findAll();
        if (manutencaoList != null){
            return new ResponseEntity<>(manutencaoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManutencaoResponseDTO> getById(@PathVariable Long id){
        ManutencaoResponseDTO manutencao = manutencaoService.findById(id);
        if (manutencao != null){
            return new ResponseEntity<>(manutencao,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<ManutencaoResponseDTO> create(@Valid @RequestBody ManutencaoRequestDTO requestDTO){
        return new ResponseEntity<>(manutencaoService.save(requestDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManutencaoResponseDTO> update(@PathVariable Long id,@Valid @RequestBody ManutencaoRequestDTO requestDTO){
        ManutencaoResponseDTO manutencaoAtualizada = manutencaoService.update(id, requestDTO);
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