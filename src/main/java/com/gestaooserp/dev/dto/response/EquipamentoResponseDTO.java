package com.gestaooserp.dev.dto.response;

public record EquipamentoResponseDTO(
        Long equipamentoId,
        String serial,
        Long clienteId,
        Long fabricanteId
) {
}
