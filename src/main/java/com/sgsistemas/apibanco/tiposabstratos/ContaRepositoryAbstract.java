package com.sgsistemas.apibanco.tiposabstratos;

import com.sgsistemas.apibanco.registro.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContaRepositoryAbstract<CONTA extends ContaBase> extends JpaRepository<CONTA, Long> {

    //findRegistroBy


}