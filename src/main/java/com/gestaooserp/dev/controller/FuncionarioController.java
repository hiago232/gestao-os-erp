package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Refatorar codigo após Implementar Exception Handler
 */


import com.gestaooserp.dev.dto.request.FuncionarioRequestDTO;
import com.gestaooserp.dev.dto.response.FuncionarioResponseDTO;
import com.gestaooserp.dev.entity.Funcionario;
import com.gestaooserp.dev.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @Operation(summary="Listar todos funcionarios",description = "Listagem de funcionarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400",description = "Requisição inválida"),
            @ApiResponse(responseCode = "403",description = "Você não tem permissão.")

    })
    @GetMapping("/")
    public ResponseEntity<List<FuncionarioResponseDTO>> getAll(){
        List<FuncionarioResponseDTO> funcionarioList = funcionarioService.findAll();
        if (funcionarioList != null){
            return new ResponseEntity<>(funcionarioList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> getById(@PathVariable Integer id){
        FuncionarioResponseDTO funcionario = funcionarioService.findById(id);
        if (funcionario != null){
            return new ResponseEntity<>(funcionario,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<FuncionarioResponseDTO> create(@Valid @RequestBody FuncionarioRequestDTO requestDTO){
        return new ResponseEntity<>(funcionarioService.save(requestDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> update(@PathVariable Integer id,@Valid @RequestBody FuncionarioRequestDTO requestDTO){
        FuncionarioResponseDTO funcionarioAtualizado = funcionarioService.update(id,requestDTO);
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
