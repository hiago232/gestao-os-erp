package com.manutencaoerp.dev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cliente_juridico")
public class ClienteJuridico extends Cliente{

    @Column(name = "cnpj",unique = true,nullable = false)
    @Getter
    @Setter
    private String cnpj;

    @Column(name = "responsavel",nullable = false)
    @Getter
    @Setter
    private String responsavel;

    @Column(name = "nome_fantasia",nullable = false)
    @Getter
    @Setter
    private String nomeFantasia;

    @Column(name = "razao_social",nullable = false)
    @Setter
    @Getter
    private String razaoSocial;

    public ClienteJuridico(){}

}
