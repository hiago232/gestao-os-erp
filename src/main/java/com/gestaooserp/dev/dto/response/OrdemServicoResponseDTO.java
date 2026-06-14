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
    public OrdemServicoResponseDTO(OrdemServico ordemServico){
        this(
                ordemServico.getOrdemServicoId(),
                ordemServico.getFuncionario().getFuncionarioId(),
                ordemServico.getCliente().getClienteId(),
                ordemServico.getManutencao().getManutencaoId(),
                ordemServico.getEquipamento().getEquipamentoId(),
                ordemServico.getServicoLocal().getServicoId()
        );
    }

}
