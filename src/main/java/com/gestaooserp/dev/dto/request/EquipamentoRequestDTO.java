package com.gestaooserp.dev.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EquipamentoRequestDTO(

        @NotBlank(message = "Serial obrigatório.")
        String serial,

        @NotNull(message = "Id do cliente obrigatório.")
        Long clienteId,

        @NotNull(message = "Id do fabricante obrigatório.")
        Long fabricanteId



) {
}
