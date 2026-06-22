package com.gestaooserp.dev.service;
/*
 * TODO:
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 */
import com.gestaooserp.dev.dto.request.ManutencaoRequestDTO;
import com.gestaooserp.dev.dto.response.ManutencaoResponseDTO;
import com.gestaooserp.dev.dto.response.OrdemServicoResponseDTO;
import com.gestaooserp.dev.entity.*;
import com.gestaooserp.dev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManutencaoService {

    private final ManutencaoRepository manutencaoRepository;
    private final OrdemServicoService ordemServicoService;

    @Autowired
    public ManutencaoService(
            ManutencaoRepository manutencaoRepository,
            OrdemServicoRepository ordemServicoRepository,
            OrdemServicoService ordemServicoService


    ){
        this.manutencaoRepository = manutencaoRepository;
        this.ordemServicoService = ordemServicoService;

    }

    public List<ManutencaoResponseDTO> findAll(){
        List<Manutencao> manutencaoList = manutencaoRepository.findAll();
        return manutencaoList.stream().map(ManutencaoResponseDTO::new).toList();
    }

    public ManutencaoResponseDTO findById(Long id){
        return new ManutencaoResponseDTO(manutencaoRepository.findById(id).orElse(null));
    }

    public ManutencaoResponseDTO save(ManutencaoRequestDTO requestDTO){
        Manutencao manutencao = manutencaoRepository.save(updateEntity(requestDTO,new Manutencao(),new OrdemServico()));
        OrdemServico ordemServico = ordemServicoService.abrirOrdemServico(
                manutencao,
                requestDTO.funcionarioId(),
                requestDTO.clienteId(),
                requestDTO.equipamentoId()
        );
        manutencao.setOrdemServico(ordemServico);
        return new ManutencaoResponseDTO(manutencaoRepository.save(manutencao));
    }

    public ManutencaoResponseDTO update(Long id,ManutencaoRequestDTO requestDTO){
        Manutencao manutencao = manutencaoRepository.findById(id).orElse(null);
        if (manutencao != null){
            OrdemServico ordemServico = ordemServicoService.findById(manutencao.getOrdemServico().getOrdemServicoId());
            return new ManutencaoResponseDTO(manutencaoRepository.save(updateEntity(requestDTO,manutencao,ordemServico)));
        }
        return null;
    }

    public Boolean delete(Long id){
        Manutencao manutencao = manutencaoRepository.findById(id).orElse(null);
        if (manutencao != null){
            manutencaoRepository.delete(manutencao);
            Long ordemServicoId = manutencao.getOrdemServico().getOrdemServicoId();
            ordemServicoService.delete(ordemServicoId);
            return true;
        }
        return false;
    }

    private Manutencao updateEntity(
            ManutencaoRequestDTO requestDTO,
            Manutencao manutencao,
            OrdemServico ordemServico
    ){
        manutencao.setOrdemServico(ordemServico);
        manutencao.setProblemaRelatado(requestDTO.problemaRelatado());
        manutencao.setDefeitoConstatado(requestDTO.defeitoConstatado());
        manutencao.setServicoRealizado(requestDTO.servicoRealizado());
        manutencao.setDataInicial(requestDTO.dataInicial());
        manutencao.setDataFinal(requestDTO.dataFinal());
        manutencao.setDataEntrada(requestDTO.dataEntrada());
        manutencao.setDataSaida(requestDTO.dataSaida());
        return manutencao;
    }
}
