package com.gestaooserp.dev.dto.response;

import java.time.LocalDate;

public record ClienteJuridicoResponseDTO(
        String cnpj,
        String razaoSocial,
        String nomeFantasia,
        LocalDate nasicmento,
        String endereco,
        String cidade,
        String estado,
        String email,
        String cep,
        String cel
) {
}
