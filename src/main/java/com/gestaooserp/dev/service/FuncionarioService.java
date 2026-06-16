package com.gestaooserp.dev.service;

/*
 * TODO:
 * - Adicionar validações de negócio
 * - Integrar tratamento global de exceções
 */
import com.gestaooserp.dev.dto.request.FuncionarioRequestDTO;
import com.gestaooserp.dev.dto.response.FuncionarioResponseDTO;
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

    public List<FuncionarioResponseDTO> findAll(){
        List<Funcionario> funcionarioList = funcionarioRepository.findAll();
        return funcionarioList.stream().map(FuncionarioResponseDTO::new).toList();
    }

    public FuncionarioResponseDTO findById(Integer id){
        return new FuncionarioResponseDTO(funcionarioRepository.findById(id).orElse(null));
    }

    public FuncionarioResponseDTO save(FuncionarioRequestDTO requestDTO){
        Funcionario funcionario = new Funcionario();
        return new FuncionarioResponseDTO(funcionarioRepository.save(updateEntity(
                requestDTO,funcionario
        )));
    }

    public FuncionarioResponseDTO update(Integer id,FuncionarioRequestDTO requestDTO){
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        if (funcionario != null){
            return new FuncionarioResponseDTO(funcionarioRepository.save(updateEntity(
                    requestDTO,funcionario
            )));
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

    private Funcionario updateEntity(FuncionarioRequestDTO requestDTO, Funcionario funcionario){
        funcionario.setNome(requestDTO.nome());
        funcionario.setNascimento(requestDTO.nascimento());
        funcionario.setDataAdmissao(requestDTO.dataAdmissao());
        funcionario.setCargo(requestDTO.cargo());
        funcionario.setCpf(requestDTO.cpf());
        funcionario.setEndereco(requestDTO.endereco());
        funcionario.setCidade(requestDTO.cidade());
        funcionario.setEstado(requestDTO.estado());
        funcionario.setEmail(requestDTO.email());
        funcionario.setCep(requestDTO.cep());
        funcionario.setCel(requestDTO.cel());
        return funcionario;
    }
}
