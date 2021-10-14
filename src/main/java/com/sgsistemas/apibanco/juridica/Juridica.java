package com.sgsistemas.apibanco.juridica;

import com.sgsistemas.apibanco.tiposabstratos.ContaBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Juridica extends ContaBase {

    private String cnpj;

    public Juridica() {
    }


}
