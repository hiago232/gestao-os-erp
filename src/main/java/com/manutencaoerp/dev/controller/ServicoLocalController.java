package com.manutencaoerp.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manutencaoerp.dev.entity.ServicoLocal;
import com.manutencaoerp.dev.service.ServicoLocalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/local")
public class ServicoLocalController {

    @Autowired
    ServicoLocalService servicoLocalService;


    @Operation(summary="Listar todas OS",description = "Listagem de OS")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "A requisição foi executada com sucesso."),
        @ApiResponse(responseCode = "400",description = "Requisição inválida"),
        @ApiResponse(responseCode = "403",description = "Você não tem permissão.")
        
    })     
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
    
}
