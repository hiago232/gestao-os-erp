package com.manutencaoerp.dev.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordem_servico_id")
    @Getter
    @Setter
    private Integer ordemServicoId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionario;

    @ManyToOne(fetch =  FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Equipamento equipamento;

    @OneToOne(mappedBy = "ordemServico",cascade = CascadeType.ALL,orphanRemoval = true)
    private Manutencao manutencao;

    @OneToOne(mappedBy = "ordemServico",cascade = CascadeType.ALL,orphanRemoval = true)
    private ServicoLocal servicoLocal;

    public OrdemServico(){}
}
