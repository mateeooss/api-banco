package com.sgsistemas.apibanco.juridica;

import com.sgsistemas.apibanco.fisica.Fisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JuridicaRepository extends JpaRepository<Juridica, Long> {
    Optional<Juridica> findPessoaByid(Long id);
}
