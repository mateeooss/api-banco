package com.sgsistemas.apibanco.tiposabstratos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class ContaServiceAbstract<CONTA extends  ContaAbstract, REPO extends JpaRepository<CONTA, Long>>{
    @Autowired
    REPO repo;


    public List<CONTA> listarTodos( ){
        return repo.findAll();
    }
    public void registrar(CONTA conta) throws Exception {
        repo.save(conta);
    }
}
