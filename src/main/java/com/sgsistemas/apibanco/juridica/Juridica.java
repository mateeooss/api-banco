package com.sgsistemas.apibanco.juridica;

import com.sgsistemas.apibanco.tiposabstratos.ContaAbstract;
import com.sgsistemas.apibanco.pessoa.Pessoa;
import com.sgsistemas.apibanco.registro.Registro;

import javax.persistence.*;
import java.util.List;

@Entity
public class Juridica extends ContaAbstract {

    private String cnpj;
    @OneToOne
    @JoinColumn(name = "juridica_id")
    private Pessoa pessoa;
    @OneToMany
    @JoinColumn(name = "juridica_id")
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

    public Juridica() {
    }

    public Juridica(String cnpj, Pessoa pessoa) {
        this.cnpj = cnpj;
        this.pessoa = pessoa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

//    public Long getId() {
//        return id;
//    }
}
