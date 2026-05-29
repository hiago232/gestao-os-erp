package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.Equipamento;
import com.gestaooserp.dev.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    @Autowired
    public EquipamentoService(EquipamentoRepository equipamentoRepository){
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<Equipamento> findAll(){
        List<Equipamento>equipamentoList = equipamentoRepository.findAll();
        return equipamentoList.stream().map(Equipamento::new).collect(Collectors.toList());
    }

    public Equipamento findById(Long id){
        return equipamentoRepository.findById(id).orElse(null);
    }

    public Equipamento save(Equipamento equipamento){
        return null; //TODO: implentar DTO
    }

    public Equipamento update(Long id, Equipamento equipamento){
        if(equipamentoRepository.findById(id).isPresent()){
            return equipamentoRepository.save(equipamento);
        }
        return null;
    }

    public Boolean delete(Long id){
        Equipamento equipamento = equipamentoRepository.findById(id).orElse(null);
        if(equipamento != null){
            equipamentoRepository.delete(equipamento);
            return true;
        }
        return false;
    }
}
