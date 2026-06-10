package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 */

import com.gestaooserp.dev.dto.request.FabricanteRequestDTO;
import com.gestaooserp.dev.dto.response.FabricanteResponseDTO;
import com.gestaooserp.dev.entity.Fabricante;
import com.gestaooserp.dev.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricanteService {

    private final FabricanteRepository fabricanteRepository;
//    private final ItemService itemService;
//    private final EquipamentoService equipamentoService;

    @Autowired
    public FabricanteService(FabricanteRepository fabricanteRepository){
        this.fabricanteRepository = fabricanteRepository;
    }

    public List<FabricanteResponseDTO> findAll(){
        List<Fabricante> fabricanteList = fabricanteRepository.findAll();
        return fabricanteList.stream().map(FabricanteResponseDTO::new).toList();
    }

    public FabricanteResponseDTO findById(Long id){
        return new FabricanteResponseDTO(fabricanteRepository.findById(id).orElse(null));
    }

    public FabricanteResponseDTO save(FabricanteRequestDTO requestDTO){
        Fabricante fabricante = new Fabricante();
        return new FabricanteResponseDTO(fabricanteRepository.save(updateEntity(fabricante,requestDTO))) ;
    }

    public FabricanteResponseDTO update(Long id,FabricanteRequestDTO requestDTO){
        Fabricante fabricante = fabricanteRepository.findById(id).orElse(null);
        if (fabricante != null){
            return new FabricanteResponseDTO(fabricanteRepository.save(updateEntity(fabricante,requestDTO))) ;
        }
        return null;
    }

    public Boolean delete(Long id){
        Fabricante fabricante = fabricanteRepository.findById(id).orElse(null);
        if (fabricante != null){
            fabricanteRepository.delete(fabricante);
            return true;
        }
        return false;
    }

    private Fabricante updateEntity(Fabricante fabricante, FabricanteRequestDTO requestDTO){
        fabricante.setCnpj(requestDTO.cnpj());
        fabricante.setRazaoSocial(requestDTO.razaoSocial());
        fabricante.setNomeFantasia(requestDTO.nomeFantasia());
        fabricante.setEndereco(requestDTO.endereco());
        fabricante.setCidade(requestDTO.cidade());
        fabricante.setEstado(requestDTO.estado());
        fabricante.setEmail(requestDTO.email());
        fabricante.setCep(requestDTO.cep());
        fabricante.setCel(requestDTO.cel());

        return fabricante;
    }
}
