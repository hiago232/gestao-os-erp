package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 */

import com.gestaooserp.dev.dto.request.EquipamentoRequestDTO;
import com.gestaooserp.dev.dto.response.EquipamentoResponseDTO;
import com.gestaooserp.dev.dto.response.FabricanteResponseDTO;
import com.gestaooserp.dev.entity.Cliente;
import com.gestaooserp.dev.entity.Equipamento;
import com.gestaooserp.dev.entity.Fabricante;
import com.gestaooserp.dev.repository.ClienteRepository;
import com.gestaooserp.dev.repository.EquipamentoRepository;
import com.gestaooserp.dev.repository.FabricanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final ClienteRepository clienteRepository;
    private final FabricanteRepository fabricanteRepository;

    public EquipamentoService(
            EquipamentoRepository equipamentoRepository,
            ClienteRepository clienteRepository,
            FabricanteRepository fabricanteRepository
    ){
        this.equipamentoRepository = equipamentoRepository;
        this.clienteRepository = clienteRepository;
        this.fabricanteRepository = fabricanteRepository;
    }

    public List<EquipamentoResponseDTO> findAll(){
        List<Equipamento>equipamentoList = equipamentoRepository.findAll();
        return equipamentoList.stream().map(EquipamentoResponseDTO::new).toList();
    }

    public EquipamentoResponseDTO findById(Long id){
        return new EquipamentoResponseDTO(equipamentoRepository.findById(id).orElse(null));
    }

    public EquipamentoResponseDTO save(EquipamentoRequestDTO requestDTO){
        Equipamento equipamento = new Equipamento();
        Cliente cliente = clienteRepository.findById(requestDTO.clienteId()).orElse(null);
        Fabricante fabricante = fabricanteRepository.findById(requestDTO.fabricanteId()).orElse(null);
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
            Cliente cliente = clienteRepository.findById(requestDTO.clienteId()).orElse(null);
            Fabricante fabricante = fabricanteRepository.findById(requestDTO.fabricanteId()).orElse(null);
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
