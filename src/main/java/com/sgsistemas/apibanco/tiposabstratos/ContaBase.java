package com.sgsistemas.apibanco.tiposabstratos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sgsistemas.apibanco.pessoa.Pessoa;
import com.sgsistemas.apibanco.registro.Registro;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ContaBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "conta_id")
    private List<Registro> registros;
    private double saldo;
    private double credito;
    private double jurosDaConta;


    public void setRegistro(Registro registro) {
        this.registros.add(registro);
    }

    public void setSaldoPositivo(double saldo) {
        this.saldo = this.saldo + saldo;
    }

    public void setSaldoNegativo(double saldo) {
        this.saldo = this.saldo - saldo;
    }


}
