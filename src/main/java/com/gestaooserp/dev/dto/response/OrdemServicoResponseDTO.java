package com.gestaooserp.dev.dto.response;

import com.gestaooserp.dev.entity.OrdemServico;

public record OrdemServicoResponseDTO(
        Long ordemServicoId,
        Integer status,
        Integer funcionarioId,
        Long clienteId,
        Long equipamentoId,
        Long manutencaoId,
        Long servicoLocalId

) {
    public OrdemServicoResponseDTO(OrdemServico ordemServico){
        this(
                ordemServico.getOrdemServicoId(),
                ordemServico.getStatus().getCodigo(),
                ordemServico.getFuncionario().getFuncionarioId(),
                ordemServico.getCliente().getClienteId(),
                ordemServico.getEquipamento().getEquipamentoId(),
                ordemServico.getManutencao() != null
                ?ordemServico.getManutencao().getManutencaoId():null,
                ordemServico.getServicoLocal() != null
                ? ordemServico.getServicoLocal().getServicoId():null
        );
    }

}
