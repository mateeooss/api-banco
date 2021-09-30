package com.sgsistemas.apibanco.fisica;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sgsistemas.apibanco.tiposabstratos.ContaAbstract;
import com.sgsistemas.apibanco.pessoa.Pessoa;
import com.sgsistemas.apibanco.registro.Registro;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Fisica extends ContaAbstract implements Serializable {

     @OneToOne
     @JoinColumn(name = "id_pessoa")
     private Pessoa pessoa;
     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JsonIgnore
     @JoinColumn(name = "fisica_ID")
     private List<Registro> registros;
     private double saldo;


     public List<Registro> getRegistros() {
          return registros;
     }

     public void setSaldo(double saldo) {
          this.saldo = saldo;
     }

     public double getSaldo() {
          return saldo;
     }

     public void setSaldoPositivo(double saldo) {
          this.saldo=this.saldo + saldo;
     }
     public void setSaldoNegativo(double saldo) {
          this.saldo=this.saldo - saldo;
     }

     public Fisica() {
     }

     public Fisica(Pessoa pessoa) {
          this.pessoa = pessoa;
     }

     public void setRegistros(Registro registros) {
          this.registros.add(registros);
     }

     public Pessoa getPessoa() {
          return pessoa;
     }

     public void setPessoa(Pessoa pessoa) {
          this.pessoa = pessoa;
     }

     public Long getId() {
          return super.getId();
     }
}
