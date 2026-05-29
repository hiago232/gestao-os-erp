package com.gestaooserp.dev.controller;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestaooserp.dev.entity.ServicoLocal;
import com.gestaooserp.dev.service.ServicoLocalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/servico-local")
public class ServicoLocalController {

    @Autowired
    ServicoLocalService servicoLocalService;


//    @Operation(summary="Listar todas OS",description = "Listagem de OS")
//    @ApiResponses(value = {
//        @ApiResponse(responseCode = "200",description = "A requisição foi executada com sucesso."),
//        @ApiResponse(responseCode = "400",description = "Requisição inválida"),
//        @ApiResponse(responseCode = "403",description = "Você não tem permissão.")
//
//    })
    @GetMapping("/")
    public ResponseEntity <List<ServicoLocal>> getAll() {
        List<ServicoLocal> servicoLocalList = servicoLocalService.findAll();
        if(servicoLocalList != null){
            return new ResponseEntity<>(servicoLocalList,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity <ServicoLocal> getById(@PathVariable Long id) {
        ServicoLocal servicoLocal =  servicoLocalService.finById(id);
        if(servicoLocal != null){
            return new ResponseEntity<>(servicoLocal,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/")
    public ResponseEntity<ServicoLocal> create(@RequestBody ServicoLocal servicoLocal){
        return new ResponseEntity<>(servicoLocalService.save(servicoLocal),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoLocal> update(@PathVariable Long id,@RequestBody ServicoLocal servicoLocal){
        ServicoLocal servicoLocalAtualizado = servicoLocalService.update(id,servicoLocal);
        if (servicoLocalAtualizado != null){
            return new ResponseEntity<>(servicoLocalAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if(servicoLocalService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    
}
