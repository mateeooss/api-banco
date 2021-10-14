package com.sgsistemas.apibanco.pessoa;

import com.sgsistemas.apibanco.fisica.Fisica;
import com.sgsistemas.apibanco.poupança.Poupança;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Poupança> findPessoaByid(Long id);
}
