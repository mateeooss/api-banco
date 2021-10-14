package com.sgsistemas.apibanco.registro;

import com.sgsistemas.apibanco.tiposabstratos.ContaBase;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

public class RegistroTransferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registrotrans_id")
    private Long id;
    private TipoMov tipoDemovimentacao;
    private double movimentacao;
    @ManyToOne
    private ContaBase contaDestino; 
    private Date data= Calendar.getInstance().getTime();
}
