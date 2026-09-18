package com.gestaooserp.dev.controller;
/*
 * TODO:
 * - Integrar tratamento global de exceções
 */

import com.gestaooserp.dev.dto.request.ClienteJuridicoRequestDTO;
import com.gestaooserp.dev.dto.response.ClienteJuridicoResponseDTO;
import com.gestaooserp.dev.entity.ClienteFisico;
import com.gestaooserp.dev.entity.ClienteJuridico;
import com.gestaooserp.dev.service.ClienteJuridicoService;
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
    public ResponseEntity<List<ClienteJuridicoResponseDTO>> getAll(){
        List<ClienteJuridicoResponseDTO> clienteJuridicoList = clienteJuridicoService.findAll();
        if (clienteJuridicoList != null){
            return new ResponseEntity<>(clienteJuridicoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteJuridicoResponseDTO> getById(@PathVariable Long id){
        ClienteJuridicoResponseDTO clienteJuridico = clienteJuridicoService.findById(id);
        return ResponseEntity.ok(clienteJuridico);

    }

    @PostMapping("/")
    public ResponseEntity<ClienteJuridicoResponseDTO> create(@Valid @RequestBody ClienteJuridicoRequestDTO requestDTO){
        return new ResponseEntity<>(clienteJuridicoService.save(requestDTO),HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteJuridicoResponseDTO> update(@PathVariable Long id,@Valid @RequestBody ClienteJuridicoRequestDTO requestDTO) {
        ClienteJuridicoResponseDTO clienteJuridico = clienteJuridicoService.update(id, requestDTO);
        return ResponseEntity.ok(clienteJuridico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteJuridicoService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
