package com.gestaooserp.dev.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "manutencao")
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manutencao_id")
    @Getter
    @Setter
    private Long manutencaoId;

    @Column(name = "problema_relatado",nullable = false)
    @Getter
    @Setter
    private String problemaRelatado;

    @Column(name = "defeito_constatado",nullable = false)
    @Getter
    @Setter
    private String defeitoConstatado;

    @Column(name = "servico_realizado",nullable = false)
    @Getter
    @Setter
    private String servicoRealizado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordem_servico_id")
    @Getter
    @Setter
    private OrdemServico ordemServico;

    @OneToMany(mappedBy = "manutencao", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    @Getter
    private List<ManutencaoItem> manutencaoItemList;

    public Manutencao(){}

    public Manutencao(Manutencao manutencao) {

    }
}
