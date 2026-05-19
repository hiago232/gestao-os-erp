package com.manutencaoerp.dev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "manutencao_item")
public class ManutencaoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manutencao_item_id")
    @Getter
    @Setter
    private Integer manutencaoItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @Getter
    @Setter
    private Manutencao manutencao;

    public ManutencaoItem(){}
}
