package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

import com.gestaooserp.dev.entity.Cliente;
import com.gestaooserp.dev.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById (Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente save (Cliente cliente){
        return null; //TODO: implentar DTO
    }

    public Cliente update(Long id,Cliente cliente){
        if(clienteRepository.findById(id).isPresent()){
            return clienteRepository.save(cliente);
        }else{
            return null;
        }
    }

    public Boolean delete (Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if(cliente != null){
            clienteRepository.delete(cliente);
            return true;
        }else{
            return false;
        }
    }
}
