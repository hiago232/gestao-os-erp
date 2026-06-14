package com.gestaooserp.dev.dto.request;

import jakarta.validation.constraints.NotNull;

public record OrdemServicoRequestDTO(

        @NotNull(message = "Id do funcionário obrigatório.")
        Integer funcionarioId,

        @NotNull(message = "Id do cliente obrigatório.")
        Long clienteId,

        @NotNull(message = "Id do equipamento obrigatório.")
        Long equipamentoId


) {
}
