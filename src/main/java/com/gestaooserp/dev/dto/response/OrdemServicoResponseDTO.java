package com.gestaooserp.dev.dto.response;

import com.gestaooserp.dev.entity.OrdemServico;

public record OrdemServicoResponseDTO(
        Long ordemServicoId,
        Integer funcionarioId,
        Long clienteId,
        Long manutencaoId,
        Long equipamentoId,
        Long servicoLocalId

) {


}
