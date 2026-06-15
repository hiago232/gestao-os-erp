package com.gestaooserp.dev.service;


import com.gestaooserp.dev.dto.request.OrdemServicoRequestDTO;
import com.gestaooserp.dev.dto.response.OrdemServicoResponseDTO;
import com.gestaooserp.dev.entity.*;
import com.gestaooserp.dev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
 * TODO:
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 */

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ClienteRepository clienteRepository;
    private final EquipamentoRepository equipamentoRepository;

    @Autowired
    public OrdemServicoService(
            OrdemServicoRepository ordemServicoRepository,
            FuncionarioRepository funcionarioRepository,
            ClienteRepository clienteRepository,
            EquipamentoRepository equipamentoRepository
    ){
        this.ordemServicoRepository = ordemServicoRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.clienteRepository = clienteRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<OrdemServicoResponseDTO> findAll(){
        List<OrdemServico> ordemServicoList = ordemServicoRepository.findAll();
        return ordemServicoList.stream().map(OrdemServicoResponseDTO::new).toList();
    }

    public OrdemServico findById(Long id){
        return new OrdemServico(ordemServicoRepository.findById(id).orElse(null));
    }

    public OrdemServico abrirOrdemServico (Manutencao manutencao, Integer funcionarioId, Long clienteId, Long equipamentoId){
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setFuncionario(funcionarioRepository.findById(funcionarioId).orElse(null));
        ordemServico.setCliente(clienteRepository.findById(clienteId).orElse(null));
        ordemServico.setEquipamento(equipamentoRepository.findById(equipamentoId).orElse(null));
        ordemServico.setManutencao(manutencao);
        return ordemServicoRepository.save(ordemServico);
    }

    public OrdemServicoResponseDTO update(Long id,OrdemServicoRequestDTO requestDTO){
        OrdemServico ordemServico = ordemServicoRepository.findById(id).orElse(null);
        if (ordemServico != null) {
            Funcionario funcionario = funcionarioRepository.findById(requestDTO.funcionarioId()).orElse(null);
            Cliente cliente = clienteRepository.findById(requestDTO.clienteId()).orElse(null);
            Equipamento equipamento = equipamentoRepository.findById(requestDTO.equipamentoId()).orElse(null);
            new OrdemServicoResponseDTO(updateEntity(ordemServico,requestDTO,funcionario,cliente,equipamento));
        }
        return null;
    }

    public Boolean delete(Long id){
        OrdemServico ordemServico = ordemServicoRepository.findById(id).orElse(null);
        if(ordemServico != null){
            ordemServicoRepository.delete(ordemServico);
            return true;
        }
        return false;

    }

    private OrdemServico updateEntity(
            OrdemServico ordemServico,
            OrdemServicoRequestDTO requestDTO,
            Funcionario funcionario,
            Cliente cliente,
            Equipamento equipamento
    ){
        ordemServico.setCliente(cliente);
        ordemServico.setFuncionario(funcionario);
        ordemServico.setEquipamento(equipamento);
        return ordemServico;
    }
}
