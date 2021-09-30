package com.sgsistemas.apibanco.fisica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.Optional;

@Repository
public interface FisicaRepository extends JpaRepository<Fisica, Long> {
  Optional<Fisica> findPessoaByid(Long id);
}
