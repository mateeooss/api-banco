package com.sgsistemas.apibanco.tiposabstratos;

import com.sgsistemas.apibanco.registro.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class ContaControllerAbstract <CONTA extends ContaBase, SERVICE extends ContaServiceAbstract>{
     @Autowired
     SERVICE service;

    @PostMapping
    public void cadastrarConta(@RequestBody CONTA conta) throws Exception {
        service.registrar(conta);
    }

    @GetMapping("/listar-todos")
    public List<CONTA> listarTodos(){
        return service.listarTodos();
    }

    @PutMapping("/{id_conta}/deposito/{valor}")
    public void deposito(@PathVariable Long id_conta, @PathVariable double valor){
        service.deposito(id_conta, valor);
    }

    @GetMapping("/extrato/{id_conta}")
    public String gerarExtrato(@PathVariable Long id_conta){
        return service.gerarExtrato(id_conta);
    }

    @PutMapping ("/{id_conta}/saque/{valor}")
    public void gerarExtrato(@PathVariable Long id_conta, @PathVariable double valor){
        service.saque(id_conta, valor);
    }

}
