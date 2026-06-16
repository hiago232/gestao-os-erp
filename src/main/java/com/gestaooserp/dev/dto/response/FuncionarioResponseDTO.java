package com.gestaooserp.dev.dto.response;

import com.gestaooserp.dev.entity.Funcionario;

import java.time.LocalDate;

public record FuncionarioResponseDTO(
        Integer funcionarioId,
        String nome,
        LocalDate dataAdmissao,
        String cargo
) {
    public FuncionarioResponseDTO(Funcionario funcionario){
        this(
                funcionario.getFuncionarioId(),
                funcionario.getNome(),
                funcionario.getDataAdmissao(),
                funcionario.getCargo()
        );
    }
}
