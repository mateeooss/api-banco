package com.sgsistemas.apibanco.tiposabstratos;

import org.springframework.data.jpa.repository.JpaRepository;

public class ContaRepositoryAbstract<CONTA extends ContaAbstract, REPO extends JpaRepository<CONTA, Long>> {

    // CONTA findPessoaByid(Long id);
}
