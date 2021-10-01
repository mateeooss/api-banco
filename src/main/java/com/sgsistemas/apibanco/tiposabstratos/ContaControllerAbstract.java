package com.sgsistemas.apibanco.tiposabstratos;

import com.sgsistemas.apibanco.juridica.Juridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class ContaControllerAbstract <CONTA extends ContaAbstract, SERVICE extends ContaServiceAbstract>{
     @Autowired
     SERVICE service;

    @PostMapping
    public void cadastrarContaFisica(@RequestBody CONTA conta) throws Exception {
        service.registrar(conta);
    }

    @GetMapping
    public abstract List<CONTA> listarTodos();


}
