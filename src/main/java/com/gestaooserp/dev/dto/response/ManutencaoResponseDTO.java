package com.gestaooserp.dev.dto.response;

import com.gestaooserp.dev.entity.Manutencao;

import java.time.LocalDate;

public record ManutencaoResponseDTO(
        Long manutencaoId,
        Integer status,
        LocalDate dataEntrada
) {

    public  ManutencaoResponseDTO(Manutencao manutencao){
        this(
                manutencao.getManutencaoId(),
                manutencao.getOrdemServico().getStatus().getCodigo(),
                manutencao.getDataEntrada()
        );
    }
}

