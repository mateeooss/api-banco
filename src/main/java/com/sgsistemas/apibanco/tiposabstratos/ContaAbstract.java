package com.sgsistemas.apibanco.tiposabstratos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sgsistemas.apibanco.pessoa.Pessoa;
import com.sgsistemas.apibanco.registro.Registro;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ContaAbstract {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "conta_abs_id")
   private Long id;
   @OneToOne
   @JoinColumn(name = "id_pessoa")
   private Pessoa pessoa;
   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JsonIgnore
   @JoinColumn(name = "fisica_ID")
   private List<Registro> registros;
   private double saldo;
   public Long getId() {
      return id;
   }

   public Pessoa getPessoa() {
      return pessoa;
   }

   public void setPessoa(Pessoa pessoa) {
      this.pessoa = pessoa;
   }

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
      this.saldo = saldo;
   }
   public abstract int tipo();
   //
//   public void setPessoa(Pessoa pessoa) {
//      this.pessoa = pessoa;
//   }
//
//   public List<Registro> getRegistros() {
//      return registros;
//   }
//
//   public void setRegistros(List<Registro> registros) {
//      this.registros = registros;
//   }
//
//   public double getSaldo() {
//      return saldo;
//   }
//
//   public void setSaldo(double saldo) {
//      this.saldo = saldo;
//   }
}
