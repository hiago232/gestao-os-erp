package com.gestaooserp.dev.service;

import com.gestaooserp.dev.dto.request.ClienteJuridicoRequestDTO;
import com.gestaooserp.dev.dto.response.ClienteJuridicoResponseDTO;
import com.gestaooserp.dev.entity.ClienteJuridico;
import com.gestaooserp.dev.repository.ClienteJuridicoRepository;
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
public class ClienteJuridicoService {

    private final ClienteJuridicoRepository clienteJuridicoRepository;

    public ClienteJuridicoService(ClienteJuridicoRepository clienteJuridicoRepository){
        this.clienteJuridicoRepository = clienteJuridicoRepository;
    }

    public List<ClienteJuridicoResponseDTO> findAll(){
        List<ClienteJuridico> clienteJuridicoList = clienteJuridicoRepository.findAll();
        return clienteJuridicoList.stream().map(ClienteJuridicoResponseDTO::new).toList();
    }

    public ClienteJuridicoResponseDTO findById(Long id){
        return new ClienteJuridicoResponseDTO(clienteJuridicoRepository.findById(id).orElse(null));
    }

    public ClienteJuridicoResponseDTO save(ClienteJuridicoRequestDTO requestDTO){
        ClienteJuridico clienteJuridico = new ClienteJuridico();

        return new ClienteJuridicoResponseDTO(clienteJuridicoRepository.save(
                updateClienteJuridico(clienteJuridico,requestDTO)));
    }

    public ClienteJuridicoResponseDTO update(Long id,ClienteJuridicoRequestDTO requestDTO ){
        ClienteJuridico clienteJuridico = clienteJuridicoRepository.findById(id).orElse(null);
        if(clienteJuridico != null){

            return new ClienteJuridicoResponseDTO(clienteJuridicoRepository.save(
                    updateClienteJuridico(clienteJuridico,requestDTO)));
        }
        return null;
    }

    public Boolean delete(Long id){
        ClienteJuridico clienteJuridico = clienteJuridicoRepository.findById(id).orElse(null);
        if(clienteJuridico != null){
            clienteJuridicoRepository.delete(clienteJuridico);
            return true;
        }
        return false;
    }

    private ClienteJuridico updateClienteJuridico(ClienteJuridico clienteJuridico,ClienteJuridicoRequestDTO requestDTO){

        clienteJuridico.setCnpj(requestDTO.cnpj());
        clienteJuridico.setRazaoSocial(requestDTO.razaoSocial());
        clienteJuridico.setNomeFantasia(requestDTO.nomeFantasia());
        clienteJuridico.setEndereco(requestDTO.endereco());
        clienteJuridico.setCidade(requestDTO.cidade());
        clienteJuridico.setEstado(requestDTO.estado());
        clienteJuridico.setEmail(requestDTO.email());
        clienteJuridico.setCep(requestDTO.cep());
        clienteJuridico.setCel(requestDTO.cel());

        return clienteJuridico;
    }
}
