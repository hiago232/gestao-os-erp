package com.gestaooserp.dev.dto.response;

import java.time.LocalDate;

public record ClienteFisicoResponseDTO(
        Long clienteFisicoId,
        String nome,
        String cpf,
        LocalDate nasicmento,
        String endereco,
        String cidade,
        String estado,
        String email,
        String cep,
        String cel

) {
}
