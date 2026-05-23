package com.gestaooserp.dev.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_id")
    @Getter
    @Setter
    private Long estoqueId;

    @Column(name = "nome",length = 150, nullable = false)
    @Getter
    @Setter
    private String nome;

    @Column(name = "endereco",length = 200, nullable = false)
    @Getter
    @Setter
    private String endereco;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    @Getter
    private List<EstoqueItem> estoqueItemList;

    public Estoque(){}

    public Estoque(Estoque estoque) {

    }
}
