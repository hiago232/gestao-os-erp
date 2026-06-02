package com.gestaooserp.dev.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="cliente")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_cliente")
public abstract class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    @Getter
    @Setter
    private Long clienteId;

    @Column(name = "endereco",nullable = false)
    @Getter
    @Setter
    private String endereco;

    @Column(name = "cidade",nullable = false)
    @Getter
    @Setter
    private String cidade;

    @Column(name = "estado",nullable = false)
    @Getter
    @Setter
    private String estado;

    @Column(name = "email",nullable = false)
    @Getter
    @Setter
    private String email;

    @Column(name = "cel",nullable = false)
    @Getter
    @Setter
    private String cel;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @Getter
    private List<Equipamento> equipamentoList;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @Getter
    private List<OrdemServico> ordemServicoList;

    public Cliente(){}


}
