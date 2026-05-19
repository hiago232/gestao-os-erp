package com.manutencaoerp.dev.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "insumo")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insumo_id",unique = true,nullable = false)
    @Getter
    @Setter
    private Integer insumoId;

    @Column(name = "nome",length = 50, nullable = false)
    @Getter
    @Setter
    private String nome;
}
