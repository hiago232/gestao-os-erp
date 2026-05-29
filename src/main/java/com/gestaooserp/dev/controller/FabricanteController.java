package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.Fabricante;
import com.gestaooserp.dev.service.FabricanteService;
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
    public ResponseEntity<List<Fabricante>> getAll(){
        List<Fabricante> fabricanteList = fabricanteService.findAll();
        if (fabricanteList != null){
            return new ResponseEntity<>(fabricanteList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> getById(@PathVariable Long id){
        Fabricante fabricante = fabricanteService.findById(id);
        if (fabricante != null){
            return new ResponseEntity<>(fabricante,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Fabricante> create(@RequestBody Fabricante fabricante){
        return new ResponseEntity<>(fabricanteService.save(fabricante),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> update(@PathVariable Long id,@RequestBody Fabricante fabricante){
        Fabricante fabricanteAtualizado = fabricanteService.update(id,fabricante);
        if (fabricanteAtualizado != null){
            return new ResponseEntity<>(fabricanteAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if (fabricanteService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}
