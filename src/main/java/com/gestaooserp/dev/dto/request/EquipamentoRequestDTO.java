package com.gestaooserp.dev.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EquipamentoRequestDTO(

        @NotBlank
        String serial,

        @NotNull
        Long clienteId,

        @NotBlank
        Long fabricanteId

) {
}
