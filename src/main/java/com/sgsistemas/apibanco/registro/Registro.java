package com.sgsistemas.apibanco.registro;


import lombok.*;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_id")
    private Long id;
    private TipoMov tipoDemovimentacao;
    private double movimentacao;
    private double valorPago;
    private Date dataDeCriacao;
    private Date dataDeGeracaoDeJuros;
    private boolean situacao;
    private double juros;

    public Registro(TipoMov tipoDemovimentacao, double movimentacao, Date data){
        this.tipoDemovimentacao = tipoDemovimentacao;
        this.movimentacao = movimentacao;
        this.dataDeCriacao = data;
        this.dataDeGeracaoDeJuros = data;
    }

    public Registro(){
    }

    public double gerarJuros(){
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        Calendar dataAtual=Calendar.getInstance();
        Calendar dataDoRegistro = Calendar.getInstance();
        dataDoRegistro.setTime(dataDeGeracaoDeJuros);
        double diasCorridos = dataAtual.get(Calendar.DAY_OF_YEAR) - dataDoRegistro.get(Calendar.DAY_OF_YEAR);


        return  diasCorridos * (movimentacao*0.02);
    }
    public TipoMov getTipoDemovimentacao() {
        return tipoDemovimentacao;
    }

    public void setTipoDemovimentacao(TipoMov tipoDemovimentacao) {
        this.tipoDemovimentacao = tipoDemovimentacao;
    }

    public void setJuros(double valor){
        this.juros = this.juros+valor;
    }
    public void quitarJuros(){
        this.juros = 0;
    }
    public double getValorPendente(){
        return (this.getMovimentacao() - this.getValorPago())+this.juros;
    }
    public void setValorPago(double valor){
        this.valorPago = this.valorPago+valor;
    }

    @Override
    public String toString() {
        return "DATA DE CRIAÇÃO: " + dataDeCriacao +
                "TIPO DE MOVIMENTAÇÃO: " + tipoDemovimentacao +
                "MOVIMENTAÇÃO: " + movimentacao +
                "VALOR PAGO: " + valorPago +
                "SITUAÇÃO:" + situacao +
                "JUROS:" + juros +
                '\n';
    }
}
