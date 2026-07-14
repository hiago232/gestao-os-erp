package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Refatorar codigo após Implementar Exception Handler
 */


import com.gestaooserp.dev.dto.request.OrdemServicoRequestDTO;
import com.gestaooserp.dev.dto.response.OrdemServicoResponseDTO;
import com.gestaooserp.dev.entity.OrdemServico;
import com.gestaooserp.dev.service.OrdemServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @Operation(summary="Listar todos serviços",description = "Listagem de serviços")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400",description = "Requisição inválida"),
            @ApiResponse(responseCode = "403",description = "Você não tem permissão.")

    })
    @GetMapping("/")
    public ResponseEntity<List<OrdemServicoResponseDTO>> getAll(){
        List<OrdemServicoResponseDTO> ordemServicoList = ordemServicoService.findAll();
        if (ordemServicoList != null){
            return new ResponseEntity<>(ordemServicoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<OrdemServicoResponseDTO> getById(@PathVariable Long id){
//        OrdemServicoResponseDTO ordemServico = ordemServicoService.findById(id);
//        if (ordemServico != null){
//            return new ResponseEntity<>(ordemServico,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<OrdemServicoResponseDTO> create(@Valid @RequestBody OrdemServicoRequestDTO requestDTO){
//        return new ResponseEntity<>(ordemServicoService.save(requestDTO),HttpStatus.CREATED);
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<OrdemServicoResponseDTO> update(@PathVariable Long id,@Valid @RequestBody OrdemServicoRequestDTO requestDTO){
//        OrdemServicoResponseDTO manutencaoAtualizada = ordemServicoService.update(id, requestDTO);
//        if (manutencaoAtualizada != null){
//            return new ResponseEntity<>(manutencaoAtualizada,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//    }

    @DeleteExchange("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if (ordemServicoService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
