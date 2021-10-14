package com.sgsistemas.apibanco.registro;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class RegistroCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_id")
    private Long id;
    private TipoMov tipoDemovimentacao;
    private double movimentacao;
    private Date data;
    private boolean situacao;

    public RegistroCredito(TipoMov tipoDemovimentacao, double movimentacao, Date data) {
        this.tipoDemovimentacao = tipoDemovimentacao;
        this.movimentacao = movimentacao;
        this.data = data;
    }
    public RegistroCredito() {
    }

    public TipoMov getTipoDemovimentacao() {
        return tipoDemovimentacao;
    }

    public void setTipoDemovimentacao(TipoMov tipoDemovimentacao) {
        this.tipoDemovimentacao = tipoDemovimentacao;
    }
//
//    public Registro(TipoDemovimentacao tipoDemovimentacao, double movimentacao, ContaAbstract contaDestino) {
//        this.tipoDemovimentacao = tipoDemovimentacao;
//        this.movimentacao = movimentacao;
//        this.contaDestino = contaDestino;
//    }

}
