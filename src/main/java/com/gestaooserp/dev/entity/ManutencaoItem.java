package com.gestaooserp.dev.entity;

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
    private Long manutencaoItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @Getter
    @Setter
    private Manutencao manutencao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @Getter
    @Setter
    private Item item;

    public ManutencaoItem(){}

    public ManutencaoItem(ManutencaoItem manutencaoItem) {

    }
}
