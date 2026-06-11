package com.gestaooserp.dev.dto.response;

import com.gestaooserp.dev.entity.ClienteJuridico;

import java.time.LocalDate;

public record ClienteJuridicoResponseDTO(
        Long clienteJuridicoId,
        String cnpj,
        String razaoSocial,
        String nomeFantasia,
        String responsavel,
        String endereco,
        String cidade,
        String estado,
        String email,
        String cep,
        String cel
) {


    public ClienteJuridicoResponseDTO(ClienteJuridico cliente) {
        this(
                cliente.getClienteId(),
                cliente.getCnpj(),
                cliente.getRazaoSocial(),
                cliente.getNomeFantasia(),
                cliente.getResponsavel(),
                cliente.getEndereco(),
                cliente.getCidade(),
                cliente.getEstado(),
                cliente.getEmail(),
                cliente.getCep(),
                cliente.getCel()
        );
    }
}
