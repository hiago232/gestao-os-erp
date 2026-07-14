package com.gestaooserp.dev.entity.enums;

public enum StatusOrdemServico {
    ABERTA(10),
    AGUARDANDO_ANALISE(20),
    EM_DIAGNOSTICO(30),
    AGUARDANDO_APROVACAO(40),
    EM_MANUTENCAO(50),
    EM_TESTES(60),
    AGUARDANDO_RETIRADA(70),
    ENCERRADA(80),
    ORCAMENTO_REPROVADO(90),
    PERDA_TOTAL(100);

    private final Integer codigo;

    StatusOrdemServico(Integer codigo){
        this.codigo = codigo;
    }

    public Integer getCodigo(){
        return codigo;
    }

    public static StatusOrdemServico valueOf(int codigo){
        for(StatusOrdemServico valor : StatusOrdemServico.values()){
            if (valor.getCodigo() == codigo){
                return valor;
            }
        }
        throw new IllegalArgumentException("Código de status inválido!");
    }

}
