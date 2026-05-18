package com.manutencaoerp.dev.entity;




import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
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

    @Column(name="escopo_servico", length = 20)
    @Getter
    @Setter
    private String escopoServico;

    @Column(name="servico_relatorio", length = 1000)
    @Getter
    @Setter
    private String servicoRelatorio;

    @Column(name="software_nome", length = 50,nullable = false)
    @Getter
    @Setter
    private String softwareNome;


    @Column(name="contato_nome",length = 50,nullable = false)
    @Getter
    @Setter
    private String contatoNome;

    @Column(name="telefone", length = 20,nullable = false)
    @Getter
    @Setter
    private String telefone;

    @Column(name="lougradouro", length = 200,nullable = false)
    @Getter
    @Setter
    private String lougradouro;

    @Column(name="bairro", length = 100,nullable = false)
    @Getter
    @Setter
    private String bairro;

    @Column(name="cep", length = 9,nullable = false)
    @Getter
    @Setter
    private String cep;

    @Column(name="cidade", length = 20,nullable = false)
    @Getter
    @Setter
    private String cidade;

    @Column(name="numero", length = 10,nullable = false)
    @Getter
    @Setter
    private String numero;

    @Column(name="uf", length = 2,nullable = false)
    @Getter
    @Setter
    private String uf;

    @Column(name = "data",nullable = false)
    @Getter
    @Setter
    private LocalDate data;

    @Column(name="hora_inicial",nullable = false)
    @Getter
    @Setter
    private LocalDateTime horaInicial;


    @Column(name="hora_final",nullable = false)
    @Getter
    @Setter
    private LocalDateTime horaFinal;


    @Column(name="duracao",nullable = false)
    @Getter
    @Setter
    private Double duracao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordem_servico_id")
    @Getter
    private OrdemServico ordemServico;

    public ServicoLocal(){}






    
}
