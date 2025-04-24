package com.crmoperacional.dev.entity;




import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="servico_local")
public class ServicoLocal {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "servico_id")
    @Getter
    @Setter
    private Long servicoId;

    @Column(name="created_by")
    @Getter
    @Setter
    private Integer created_by;

    @Column(name="tecnico_id")
    @Getter
    @Setter
    private Integer tecnicoId;

    @Column(name="cliente_id")
    @Getter
    @Setter
    private Long clienteId;

    @Column(name="equipamento_id")
    @Getter
    @Setter
    private Long equipamentoId;

    @Column(name="escopo_servico")
    @Getter
    @Setter
    private Integer escopoServico;

    @Column(name="cnpj")
    @Getter
    @Setter String cnpj;

    @Column(name="serial")
    @Getter
    @Setter
    private String serial;

    @Column(name="contato_id")
    @Getter
    @Setter
    private Long contatoId;

    @Column(name="contato")
    @Getter
    @Setter
    private String contato;

    @Column(name="telefone")
    @Getter
    @Setter
    private String telefone;

    @Column(name="lougradouro")
    @Getter
    @Setter
    private String lougradouro;

    @Column(name="bairro")
    @Getter
    @Setter
    private String bairro;

    @Column(name="cep")
    @Getter
    @Setter
    private String cep;

    @Column(name="cidade")
    @Getter
    @Setter
    private String cidade;

    @Column(name="numero")
    @Getter
    @Setter
    private String numero;

    @Column(name="uf")
    @Getter
    @Setter
    private String uf;

    @Column(name="hora_inicial")
    @Getter
    @Setter
    private LocalDateTime horaInicial;


    @Column(name="hora_final")
    @Getter
    @Setter
    private LocalDateTime horaFinal;

    
}
