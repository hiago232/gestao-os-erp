package com.gestaooserp.dev.dto.response;

public record OrdemServicoResponseDTO(
        Long ordemServicoId,
        Integer funcionarioId,
        Long clienteId,
        Long manutencaoId,
        Long equipamentoId,
        Long servicoLocalId

) {
}
