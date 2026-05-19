package com.manutencaoerp.dev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servico_local_item")
public class ServicoLocalItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servico_local_item_id",unique = true)
    @Getter
    @Setter
    private Integer servicoLocalItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @Getter
    @Setter
    private ServicoLocal servicoLocal;

    public ServicoLocalItem(){}
}
