package com.gestaooserp.dev.dto.response;

import com.gestaooserp.dev.entity.Manutencao;

import java.time.LocalDate;

public record ManutencaoResponseDTO(
        Long manutencaoId,
        Integer funcionarioId,
        Long clienteId,
        Long equipamentoId,
        String status,
        String problemaRelatado,
        String defeitoConstatado,
        String servicoRealizado,
        LocalDate dataEntrada,
        LocalDate dataInicial,
        LocalDate dataFinal,
        LocalDate dataSaida
        ) {

    public  ManutencaoResponseDTO(Manutencao manutencao){
        this(
                manutencao.getManutencaoId(),
                manutencao.getOrdemServico().getFuncionario().getFuncionarioId(),
                manutencao.getOrdemServico().getCliente().getClienteId(),
                manutencao.getOrdemServico().getEquipamento().getEquipamentoId(),
                manutencao.getOrdemServico().getStatus().name(),
                manutencao.getProblemaRelatado(),
                manutencao.getDefeitoConstatado(),
                manutencao.getServicoRealizado(),
                manutencao.getDataEntrada(),
                manutencao.getDataInicial(),
                manutencao.getDataFinal(),
                manutencao.getDataSaida()
        );
    }
}

