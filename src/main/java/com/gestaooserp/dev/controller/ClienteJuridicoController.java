package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Implementar anotation @Valid para validações
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.ClienteFisico;
import com.gestaooserp.dev.entity.ClienteJuridico;
import com.gestaooserp.dev.service.ClienteJuridicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente/juridico")
public class ClienteJuridicoController {

    private final ClienteJuridicoService clienteJuridicoService;

    public ClienteJuridicoController(ClienteJuridicoService clienteJuridicoService){
        this.clienteJuridicoService = clienteJuridicoService;
    }

    @Operation(summary="Listar todos clientes juridicos",description = "Listagem de cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400",description = "Requisição inválida"),
            @ApiResponse(responseCode = "403",description = "Você não tem permissão.")

    })

    @GetMapping("/")
    public ResponseEntity<List<ClienteJuridico>> getAll(){
        List<ClienteJuridico> clienteJuridicoList = clienteJuridicoService.findAll();
        if (clienteJuridicoList != null){
            return new ResponseEntity<>(clienteJuridicoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteJuridico> getById(@PathVariable Long id){
        ClienteJuridico clienteJuridico = clienteJuridicoService.findById(id);
        if (clienteJuridico != null){
            return new ResponseEntity<>(clienteJuridico,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<ClienteJuridico> create(@RequestBody ClienteJuridico clienteJuridico){
        return new ResponseEntity<>(clienteJuridicoService.save(clienteJuridico),HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteJuridico> update(@PathVariable Long id,@RequestBody ClienteJuridico clienteJuridico){
        ClienteJuridico clienteJuridicoAtualizado = clienteJuridicoService.update(id,clienteJuridico);
        if (clienteJuridicoAtualizado != null){
            return new ResponseEntity<>(clienteJuridicoAtualizado,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        if (clienteJuridicoService.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
