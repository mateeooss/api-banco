package com.sgsistemas.apibanco.poupança;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PoupançaRepository extends JpaRepository<Poupança, Long> {
    boolean findPessoaByid(Long id);
}
