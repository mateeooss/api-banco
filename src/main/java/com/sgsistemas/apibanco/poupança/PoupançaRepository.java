package com.sgsistemas.apibanco.poupança;

import com.sgsistemas.apibanco.fisica.Fisica;
import com.sgsistemas.apibanco.tiposabstratos.ContaRepositoryAbstract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface poupançaRepository extends JpaRepository<Poupança, Long> {
    Optional<Poupança> findPessoaByid(Long id);
}
