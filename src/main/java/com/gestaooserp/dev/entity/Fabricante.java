package com.gestaooserp.dev.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fabricante_id",length = 10)
    @Getter
    @Setter
    private Long fabricanteId;

    @Column(name = "cnpj",length = 25, unique = true,nullable = false)
    @Getter
    @Setter
    private String cnpj;

    @Column(name = "nome_fantasia",nullable = false)
    @Getter
    @Setter
    private String nomeFantasia;

    @Column(name = "razao_social",nullable = false)
    @Setter
    @Getter
    private String razaoSocial;

    @Column(name = "endereco",nullable = false)
    @Getter
    @Setter
    private String endereco;

    @Column(name = "cidade",length = 200, nullable = false)
    @Getter
    @Setter
    private String cidade;

    @Column(name = "estado",length = 2, nullable = false)
    @Getter
    @Setter
    private String estado;


    @Column(name = "cep",length = 10,nullable = false)
    @Getter
    @Setter
    private String cep;

    @Column(name = "telefone",length = 20, nullable = false)
    @Getter
    @Setter
    private String telefone;

    @Column(name = "email",length = 100, nullable = false)
    @Getter
    @Setter
    private String email;

    @OneToMany(mappedBy = "fabricante",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    @Getter
    @Setter
    private List<Equipamento> equipamentoList;

    @OneToMany(mappedBy = "fabricante",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    @Getter
    @Setter
    private List<Item> itemList;

    public Fabricante(Fabricante fabricante) {

    }
}
