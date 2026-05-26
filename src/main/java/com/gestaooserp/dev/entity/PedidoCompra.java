package com.gestaooserp.dev.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido_compra")
public class PedidoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_compra_id")
    @Getter
    @Setter
    private Long pedidoCompraId;

    @Column(name = "data",nullable = false)
    @Getter
    @Setter
    private LocalDate data;

    @Column(name = "valor_total",nullable = false)
    @Getter
    @Setter
    private  Double valorTotal;

    @OneToMany(mappedBy = "pedidoCompra", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    @Getter
    private List<PedidoCompraItem> pedidoCompraItemList;

    public PedidoCompra(PedidoCompra pedidoCompra) {

    }
}
