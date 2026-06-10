package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Refatorar codigo após Implementar Exception Handler
 */

import com.gestaooserp.dev.dto.request.EquipamentoRequestDTO;
import com.gestaooserp.dev.dto.response.EquipamentoResponseDTO;
import com.gestaooserp.dev.entity.Equipamento;
import com.gestaooserp.dev.service.EquipamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @Operation(summary="Listar todos equipamentos",description = "Listagem de equipamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400",description = "Requisição inválida"),
            @ApiResponse(responseCode = "403",description = "Você não tem permissão.")

    })
    @GetMapping("/")
    public ResponseEntity<List<EquipamentoResponseDTO>> getAll(){
        List<EquipamentoResponseDTO> equipamentoList = equipamentoService.findAll();
        if (equipamentoList != null){
            return new ResponseEntity<>(equipamentoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoResponseDTO> getById(@PathVariable Long id){
        EquipamentoResponseDTO equipamento = equipamentoService.findById(id);
        if (equipamento != null){
            return new ResponseEntity<>(equipamento,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<EquipamentoResponseDTO> create(@Valid @RequestBody EquipamentoRequestDTO equipamento){
        return new ResponseEntity<>(equipamentoService.save(equipamento),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoResponseDTO> update(@PathVariable Long id,@Valid @RequestBody EquipamentoRequestDTO equipamento){
        EquipamentoResponseDTO equipamentoAtualizado = equipamentoService.update(id,equipamento);
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
