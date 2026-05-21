package com.gestaooserp.dev.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaooserp.dev.entity.ServicoLocal;
import com.gestaooserp.dev.repository.ServicoLocalRepository;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */

@Service
public class ServicoLocalService {

    private final ServicoLocalRepository servicoLocalRepository;

    @Autowired
    public ServicoLocalService(ServicoLocalRepository servicoLocalRepository){
        this.servicoLocalRepository = servicoLocalRepository;
    }

    public List<ServicoLocal> findAll(){
        List<ServicoLocal> servicoLocalList = servicoLocalRepository.findAll();
        return servicoLocalList.stream().map(ServicoLocal::new).collect(Collectors.toList());
    }

    public ServicoLocal finById(Long id){
        return servicoLocalRepository.findById(id).orElse(null);
    }

    public ServicoLocal saveServicoLocal(ServicoLocal servicoLocal){
        return null; //TODO: implentar DTO
    }

    public ServicoLocal updateServicoLocal(Long id, ServicoLocal servicoLocal){
        if (servicoLocalRepository.findById(id).isPresent()){
            return servicoLocalRepository.save(servicoLocal);
        }else{
            return null;
        }
    }

    public Boolean deleteServicoLocal(Long id){
        ServicoLocal servicoLocal = servicoLocalRepository.findById(id).orElse(null);
        if(servicoLocal != null){
            servicoLocalRepository.delete(servicoLocal);
            return true;
        }else{
            return false;
        }

    }


}
