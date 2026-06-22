package com.gestaooserp.dev.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordem_servico_id")
    @Getter
    @Setter
    private Long ordemServicoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id")
    @Getter
    @Setter
    private Funcionario funcionario;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @Getter
    @Setter
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipamento_id")
    @JsonBackReference
    @Getter
    @Setter
    private Equipamento equipamento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manutencao_id")
    @Getter
    @Setter
    private Manutencao manutencao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_local_id")
    @Getter
    @Setter
    private ServicoLocal servicoLocal;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    @Getter
    private List<AtendimentoRemoto> atendimentoRemotoList;

    public OrdemServico(){}

    public OrdemServico(OrdemServico ordemServico) {
    }
}
