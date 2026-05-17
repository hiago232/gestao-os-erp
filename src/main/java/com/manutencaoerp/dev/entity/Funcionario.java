package com.manutencaoerp.dev.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id",unique = true,nullable = false)
    @Getter
    @Setter
    private Integer funcionarioId;

    @Column(name = "data_admissao",nullable = false)
    @Getter
    @Setter
    private LocalDate dataAdmissao;

    @Column(name = "cargo",nullable = false)
    @Getter
    @Setter
    private String cargo;

    @Column(name = "endereco",nullable = false)
    @Getter
    @Setter
    private String endereco;

    @Column(name = "cidade",nullable = false)
    @Getter
    @Setter
    private String cidade;

    @Column(name = "estado",nullable = false)
    @Getter
    @Setter
    private String estado;

    @Column(name = "email",nullable = false)
    @Getter
    @Setter
    private String email;

    @Column(name = "cep",nullable = false)
    @Getter
    @Setter
    private String cep;

    @Column(name = "cel",nullable = false)
    @Getter
    @Setter
    private String cel;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @Getter
    private List<OrdemServico> ordemServicoList;


}
