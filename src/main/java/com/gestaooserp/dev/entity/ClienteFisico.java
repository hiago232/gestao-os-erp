package com.gestaooserp.dev.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "cliente_fisico")
public class ClienteFisico extends Cliente{

    @Column(name = "cpf",unique = true,nullable = false)
    @Getter
    @Setter
    private String cpf;

    @Column(name = "nome",nullable = false)
    @Getter
    @Setter
    private String nome;

    @Column(name = "nascimento",nullable = false)
    @Getter
    @Setter
    private LocalDate nascimento;

    public ClienteFisico(){}

    public ClienteFisico(ClienteFisico clienteFisico) {
    }
}

