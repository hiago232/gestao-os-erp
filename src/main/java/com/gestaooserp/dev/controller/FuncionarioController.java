package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.Funcionario;
import com.gestaooserp.dev.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Funcionario>> getAll(){
        List<Funcionario> funcionarioList = funcionarioService.findAll();
        if (funcionarioList != null){
            return new ResponseEntity<>(funcionarioList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable Integer id){
        Funcionario funcionario = funcionarioService.findById(id);
        if (funcionario != null){
            return new ResponseEntity<>(funcionario,HttpStatus.OK)
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
        return new ResponseEntity<>(funcionarioService.save(funcionario),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Integer id,@RequestBody Funcionario funcionario){
        Funcionario funcionarioAtualizado = funcionarioService.update(id,funcionario);
        if (funcionarioAtualizado != null){
            return new ResponseEntity<>(funcionarioAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        if (funcionarioService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }


}
