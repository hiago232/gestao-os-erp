package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Integrar tratamento global de exceções
 */

import com.gestaooserp.dev.dto.request.FabricanteRequestDTO;
import com.gestaooserp.dev.dto.response.FabricanteResponseDTO;
import com.gestaooserp.dev.entity.Fabricante;
import com.gestaooserp.dev.entity.Item;
import com.gestaooserp.dev.service.EquipamentoService;
import com.gestaooserp.dev.service.FabricanteService;
import com.gestaooserp.dev.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fabricante")
public class FabricanteController {

    private final FabricanteService fabricanteService;


    public FabricanteController(FabricanteService fabricanteService){
        this.fabricanteService = fabricanteService;
    }

    @GetMapping("/")
    public ResponseEntity<List<FabricanteResponseDTO>> getAll(){
        List<FabricanteResponseDTO> fabricanteList = fabricanteService.findAll();
        if (fabricanteList != null){
            return new ResponseEntity<>(fabricanteList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteResponseDTO> getById(@PathVariable Long id){
        FabricanteResponseDTO fabricante = fabricanteService.findById(id);
        return ResponseEntity.ok(fabricante);
    }

    @PostMapping("/")
    public ResponseEntity<FabricanteResponseDTO> create(@Valid @RequestBody FabricanteRequestDTO requestDTO){
        return new ResponseEntity<>(fabricanteService.save(requestDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricanteResponseDTO> update(@PathVariable Long id,@Valid @RequestBody FabricanteRequestDTO requestDTO){
        FabricanteResponseDTO fabricante = fabricanteService.update(id,requestDTO);
        return ResponseEntity.ok(fabricante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fabricanteService.delete(id);
        return ResponseEntity.ok(null);
    }

}
