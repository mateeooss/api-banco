package com.sgsistemas.apibanco.juridica;

import com.sgsistemas.apibanco.fisica.Fisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface JuridicaRepository extends JpaRepository<Juridica, Long> {
    Optional<Juridica> findPessoaByid(Long id);

    @Query(nativeQuery = true,value = "select * from JURIDICA where CONTA_ABS_ID = :id")
    Collection<Fisica> verificarConta(@Param("id") Long id);
}
