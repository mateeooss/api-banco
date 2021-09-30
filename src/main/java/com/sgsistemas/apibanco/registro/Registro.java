package com.sgsistemas.apibanco.registro;


import com.sgsistemas.apibanco.tiposabstratos.ContaAbstract;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoDemovimentacao tipoDemovimentacao;
    private double movimentacao;
    @ManyToOne
    @JoinColumn(name = "conta_abs_id")
    private ContaAbstract contaDestino;
    private Date data= Calendar.getInstance().getTime();


    public ContaAbstract getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(ContaAbstract contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Long getId() {
        return id;
    }

    public TipoDemovimentacao getTipoDemovimentacao() {
        return tipoDemovimentacao;
    }

    public double getMovimentacao() {
        return movimentacao;
    }

    public Date getData() {
        return data;
    }

    public void setTipoDemovimentacao(TipoDemovimentacao tipoDemovimentacao) {
        this.tipoDemovimentacao = tipoDemovimentacao;
    }

    public void setMovimentacao(double movimentacao) {
        this.movimentacao = movimentacao;
    }

    public void setData(Date data) {
        this.data = data;
    }
    public Registro() {

    }
    public Registro(TipoDemovimentacao tipoDemovimentacao, double movimentacao) {
        this.tipoDemovimentacao = tipoDemovimentacao;
        this.movimentacao = movimentacao;
    }

    public Registro(TipoDemovimentacao tipoDemovimentacao, double movimentacao, ContaAbstract contaDestino) {
        this.tipoDemovimentacao = tipoDemovimentacao;
        this.movimentacao = movimentacao;
        this.contaDestino = contaDestino;
    }



    public enum TipoDemovimentacao{
   TRANSFERENCIA, SAQUE, DEPOSITO, LIMITE_CREDITO  }
}
