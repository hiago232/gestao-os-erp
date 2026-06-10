package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.dto.request.EquipamentoRequestDTO;
import com.gestaooserp.dev.dto.response.EquipamentoResponseDTO;
import com.gestaooserp.dev.entity.Cliente;
import com.gestaooserp.dev.entity.Equipamento;
import com.gestaooserp.dev.entity.Fabricante;
import com.gestaooserp.dev.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final ClienteService clienteService;
    private final FabricanteService fabricanteService;

    public EquipamentoService(
            EquipamentoRepository equipamentoRepository,
            ClienteService clienteService,
            FabricanteService fabricanteService
    ){
        this.equipamentoRepository = equipamentoRepository;
        this.clienteService = clienteService;
        this.fabricanteService = fabricanteService;
    }

    public List<EquipamentoResponseDTO> findAll(){
        List<Equipamento>equipamentoList = equipamentoRepository.findAll();
        return equipamentoList.stream().map(EquipamentoResponseDTO::new).collect(Collectors.toList());
    }

    public EquipamentoResponseDTO findById(Long id){
        return new EquipamentoResponseDTO(equipamentoRepository.findById(id).orElse(null));
    }

    public EquipamentoResponseDTO save(EquipamentoRequestDTO requestDTO){
        Equipamento equipamento = new Equipamento();
        Cliente cliente = clienteService.findById(requestDTO.clienteId());
        Fabricante fabricante = fabricanteService.findById(requestDTO.fabricanteId());
        return new EquipamentoResponseDTO(equipamentoRepository.save(updateEntity(
                requestDTO,
                equipamento,
                cliente,
                fabricante
        )));
    }

    public EquipamentoResponseDTO update(Long id, EquipamentoRequestDTO requestDTO){
        Equipamento equipamento = equipamentoRepository.findById(id).orElse(null);
        if(equipamento != null ){
            Cliente cliente = equipamento.getCliente();
            Fabricante fabricante = equipamento.getFabricante();
            return new EquipamentoResponseDTO(equipamentoRepository.save(updateEntity(
                    requestDTO,
                    equipamento,
                    cliente,
                    fabricante
            )));
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

    private Equipamento updateEntity(
            EquipamentoRequestDTO requestDTO,
            Equipamento equipamento,
            Cliente cliente,
            Fabricante fabricante
    ){
        equipamento.setSerial(requestDTO.serial());
        equipamento.setCliente(cliente);
        equipamento.setFabricante(fabricante);
        return equipamento;
    }
}
