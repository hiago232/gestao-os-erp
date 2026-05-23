package com.gestaooserp.dev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "atendimento_remoto")
public class AtendimentoRemoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atendimento_remoto_id")
    @Getter
    @Setter
    private Long atendimentoRemotoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @Getter
    @Setter
    private OrdemServico ordemServico;

    @Column(name = "problema_relatado",nullable = false)
    @Getter
    @Setter
    private String problemaRelatado;

    @Column(name = "defeito_constatado",nullable = false)
    @Getter
    @Setter
    private String defeitoConstatado;

    @Column(name="atendimento_relatorio", length = 1000)
    @Getter
    @Setter
    private String atendimentoRelatorio;

    @Column(name = "data",nullable = false)
    @Getter
    @Setter
    private LocalDate data;

    @Column(name = "hora_inicial",nullable = false)
    @Getter
    @Setter
    private LocalDateTime horaInicial;

    @Column(name = "hora_final",nullable = false)
    @Getter
    @Setter
    private LocalDateTime horaFinal;


    public AtendimentoRemoto(AtendimentoRemoto atendimentoRemoto) {

    }
}
