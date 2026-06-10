package com.gestaooserp.dev.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "equipamento")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipamento_id")
    @Getter
    @Setter
    private Long equipamentoId;

    @Column(name = "serial",length = 50,nullable = false)
    @Getter
    @Setter
    private String serial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @Getter
    @Setter
    private Cliente cliente;

    @OneToMany(mappedBy = "equipamento", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    @Getter
    private List<OrdemServico> ordemServicoList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @Getter
    @Setter
    private Fabricante fabricante;

    public Equipamento(){}

    public Equipamento(Equipamento equipamento) {

    }
}
