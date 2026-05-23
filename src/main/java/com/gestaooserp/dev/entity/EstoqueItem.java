package com.gestaooserp.dev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estoque_item")
public class EstoqueItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_item_id",nullable = false)
    @Getter
    @Setter
    private Long estoqueItemId;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @Getter
    @Setter
    private Item item;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @Getter
    @Setter
    private Estoque estoque;

    @Column(name = "quantidade",length = 10, nullable = false)
    @Getter
    @Setter
    private Integer quantidade;

    public EstoqueItem(){}

    public EstoqueItem(EstoqueItem estoqueItem) {

    }
}
