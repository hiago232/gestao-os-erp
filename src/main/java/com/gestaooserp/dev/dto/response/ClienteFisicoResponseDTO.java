package com.gestaooserp.dev.dto.response;

import java.time.LocalDate;

public record ClienteFisicoResponseDTO(
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
