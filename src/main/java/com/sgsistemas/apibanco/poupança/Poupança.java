package com.sgsistemas.apibanco.poupança;

import com.sgsistemas.apibanco.tiposabstratos.ContaAbstract;
import com.sgsistemas.apibanco.pessoa.Pessoa;
import com.sgsistemas.apibanco.registro.Registro;

import javax.persistence.*;
import java.util.List;

@Entity
public class Poupança extends ContaAbstract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pessoa pessoa;
    @OneToMany
    @JoinColumn(name = "poupanca_id")
    private List<Registro> registros;
    private double saldo;




    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo=+saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }
    @Override
    public int tipo(){
        return 1;
    }
}
