package com.gestaooserp.dev.service;


import com.gestaooserp.dev.dto.request.OrdemServicoRequestDTO;
import com.gestaooserp.dev.dto.response.OrdemServicoResponseDTO;
import com.gestaooserp.dev.entity.*;
import com.gestaooserp.dev.entity.enums.StatusOrdemServico;
import com.gestaooserp.dev.exception.BusinessRuleException;
import com.gestaooserp.dev.exception.ResourceNotFoundException;
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
    private final ManutencaoRepository manutencaoRepository;

    @Autowired
    public OrdemServicoService(
            OrdemServicoRepository ordemServicoRepository,
            FuncionarioRepository funcionarioRepository,
            ClienteRepository clienteRepository,
            EquipamentoRepository equipamentoRepository,
            ManutencaoRepository manutencaoRepository
    ){
        this.ordemServicoRepository = ordemServicoRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.clienteRepository = clienteRepository;
        this.equipamentoRepository = equipamentoRepository;
        this.manutencaoRepository  = manutencaoRepository;
    }

    public List<OrdemServicoResponseDTO> findAll(){
        List<OrdemServico> ordemServicoList = ordemServicoRepository.findAll();
        return ordemServicoList.stream().map(OrdemServicoResponseDTO::new).toList();
    }

    public OrdemServico findById(Long id){
        return new OrdemServico(ordemServicoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ordem de Serviço ID#"+id+" inexistente!")));
    }

    public OrdemServico abrirOrdemServico (Manutencao manutencao,Integer funcionarioId, Long clienteId, Long equipamentoId){
        OrdemServico ordemServico = new OrdemServico();
        Integer status = 10;
        ordemServico = updateEntity(ordemServico,funcionarioId,clienteId,equipamentoId,status);
        ordemServico.setManutencao(manutencao);
        return ordemServicoRepository.save(ordemServico);
    }


    public OrdemServico atualizaOrdemServico (Manutencao manutencao,Integer status,Integer funcionarioId, Long clienteId, Long equipamentoId){
        OrdemServico ordemServico = manutencao.getOrdemServico();
        OrdemServico ordemServicoAtualizada = updateEntity(
                ordemServico,
                funcionarioId,
                clienteId,
                equipamentoId,
                status
        );
        ordemServicoAtualizada.setManutencao(manutencao);
        return ordemServicoRepository.save(ordemServicoAtualizada);
    }

//    public OrdemServicoResponseDTO update(Long id,OrdemServicoRequestDTO requestDTO){
//        OrdemServico ordemServico = ordemServicoRepository.findById(id).orElse(null);
//        if (ordemServico != null) {
//            return new OrdemServicoResponseDTO(ordemServicoRepository.save(updateEntity(
//                    ordemServico,
//                    requestDTO.funcionarioId(),
//                    requestDTO.clienteId(),
//                    requestDTO.equipamentoId(),
//                    requestDTO.
//                    )
//            ));
//        }
//        return null;
//    }

//    public Boolean delete(Long id){
//        OrdemServico ordemServico = ordemServicoRepository.findById(id).orElse(null);
//        if(ordemServico != null){
//            manutencaoRepository.delete(ordemServico.getManutencao());
//            ordemServicoRepository.delete(ordemServico);
//            return true;
//        }
//        return false;
//
//    }

    private OrdemServico updateEntity(
            OrdemServico ordemServico,
            Integer funcionarioId,
            Long clienteId,
            Long equipamentoId,
            Integer status
    ){

        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(() ->
                new ResourceNotFoundException("Funcionario inexistente. ID "+ funcionarioId));
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() ->
                new ResourceNotFoundException("Cliente inexistente. ID "+ clienteId));
        Equipamento equipamento = equipamentoRepository.findById(equipamentoId).orElseThrow(() ->
                new ResourceNotFoundException("Equipamento inexistente. ID "+ equipamentoId));

        if (!equipamento.getCliente().equals(cliente)){
            throw new BusinessRuleException("Equipamento não pertence ao cliente.");
        }
        ordemServico.setStatus(StatusOrdemServico.valueOf(status));
        ordemServico.setCliente(cliente);
        ordemServico.setFuncionario(funcionario);
        ordemServico.setEquipamento(equipamento);
        return ordemServico;
    }
}
