package com.gestaooserp.dev.dto.response;

import com.gestaooserp.dev.entity.Equipamento;

public record EquipamentoResponseDTO(
        Long equipamentoId,
        String serial,
        Long clienteId,
        Long fabricanteId
) {

    public  EquipamentoResponseDTO(Equipamento equipamento){
        this(
                equipamento.getEquipamentoId(),
                equipamento.getSerial(),
                equipamento.getCliente().getClienteId(),
                equipamento.getFabricante().getFabricanteId()

        );
    }
}
