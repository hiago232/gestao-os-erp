package com.gestaooserp.dev.dto.request;

import jakarta.validation.constraints.NotNull;

public record OrdemServicoRequestDTO(

        @NotNull
        Long funcionarioId,

        @NotNull
        Long clienteId,

        @NotNull
        Long equipamentoId


) {
}
