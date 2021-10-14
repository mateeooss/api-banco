package com.sgsistemas.apibanco.pessoa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Long id;
    private String cpf;
    private String nome;

    public Pessoa() {
    }

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }


}
