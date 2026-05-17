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

    @Column(name="created_by", length = 20)
    @Getter
    @Setter
    private Integer created_by;

    @Column(name="tecnico_id" , length = 10)
    @Getter
    @Setter
    private Integer tecnicoId;

    @Column(name="tecnico_nome", length = 20)
    @Getter
    @Setter
    private String tecnicoNome;


    @Column(name="cliente_id", length = 10)
    @Getter
    @Setter
    private Long clienteId;

    @Column(name="equipamento_id", length = 10)
    @Getter
    @Setter
    private Long equipamentoId;

    @Column(name="escopo_servico", length = 20)
    @Getter
    @Setter
    private String escopoServico;

    @Column(name="relatorio_servico", length = 1000)
    @Getter
    @Setter
    private String relatorioServico;

    @Column(name="software_nome", length = 50)
    @Getter
    @Setter
    private String softwareNome;

    @Column(name="cnpj", length = 15)
    @Getter
    @Setter String cnpj;

    @Column(name="serial", length = 100)
    @Getter
    @Setter
    private String serial;

    @Column(name="contato_id", length = 10)
    @Getter
    @Setter
    private Long contatoId;

    @Column(name="contato_nome",length = 50)
    @Getter
    @Setter
    private String contatoNome;

    @Column(name="telefone", length = 20)
    @Getter
    @Setter
    private String telefone;

    @Column(name="lougradouro", length = 200)
    @Getter
    @Setter
    private String lougradouro;

    @Column(name="bairro", length = 100)
    @Getter
    @Setter
    private String bairro;

    @Column(name="cep", length = 9)
    @Getter
    @Setter
    private String cep;

    @Column(name="cidade", length = 20)
    @Getter
    @Setter
    private String cidade;

    @Column(name="numero", length = 10)
    @Getter
    @Setter
    private String numero;

    @Column(name="uf", length = 2)
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


    @Column(name="duracao", length = 10)
    @Getter
    @Setter
    private Integer duracao;






    
}
