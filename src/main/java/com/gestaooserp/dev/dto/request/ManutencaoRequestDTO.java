package com.gestaooserp.dev.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ManutencaoRequestDTO(

        @NotNull(message = "Id do funcionário obrigatório.")
        Integer funcionarioId,

        @NotNull(message = "Id do cliente obrigatório.")
        Long clienteId,

        @NotNull(message = "Id do equipamento obrigatório.")
        Long equipamentoId,

        @NotNull(message = "Problema relatado obrigatório.")
        String problemaRelatado,

        String defeitoConstatado,
        String servicoRealizado,
        LocalDate dataInicial,
        LocalDate dataFinal,

        @NotNull(message = "Data de entrada obrigatória.")
        LocalDate dataEntrada,

        String dataSaida


) {
}
