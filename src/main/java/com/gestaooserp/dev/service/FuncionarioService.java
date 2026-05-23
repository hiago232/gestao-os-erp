package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Implementar DTOs para requests/responses
 * - Logo apos implementar DTO, implementar metodo save
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 * - Melhorar separação entre domínio e camada HTTP
 */
import com.gestaooserp.dev.entity.Funcionario;
import com.gestaooserp.dev.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> findAll(){
        List<Funcionario> funcionarioList = funcionarioRepository.findAll();
        return funcionarioList.stream().map(Funcionario::new).collect(Collectors.toList());
    }

    public Funcionario findById(Integer id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Funcionario save(Funcionario funcionario){
        return null; //TODO: implentar DTO
    }

    public Funcionario update(Integer id,Funcionario funcionario){
        if (funcionarioRepository.findById(id).isPresent()){
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }

    public Boolean delete(Integer id){
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        if (funcionario != null){
            funcionarioRepository.delete(funcionario);
            return true;
        }
        return false;
    }
}
