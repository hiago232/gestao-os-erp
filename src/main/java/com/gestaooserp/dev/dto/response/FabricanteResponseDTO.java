package com.gestaooserp.dev.dto.response;

import com.gestaooserp.dev.entity.Fabricante;

public record FabricanteResponseDTO(
        Long fabricanteId,
        String cnpj,
        String razaoSocial,
        String nomeFantasia,
        String endereco,
        String cidade,
        String estado,
        String email,
        String cep,
        String cel
) {
    public FabricanteResponseDTO(Fabricante fabricante){
        this(
                fabricante.getFabricanteId(),
                fabricante.getCnpj(),
                fabricante.getRazaoSocial(),
                fabricante.getNomeFantasia(),
                fabricante.getEndereco(),
                fabricante.getCidade(),
                fabricante.getEstado(),
                fabricante.getEmail(),
                fabricante.getCep(),
                fabricante.getCel()
        );
    }
}
