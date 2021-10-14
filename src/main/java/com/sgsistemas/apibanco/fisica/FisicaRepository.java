package com.sgsistemas.apibanco.fisica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FisicaRepository extends JpaRepository<Fisica, Long> {
    Optional<Fisica> findPessoaByid(Long id);

    @Query(nativeQuery = true, value = "select * from FISICA where CONTA_ABS_ID = :id")
    Collection<Fisica> verificarConta(@Param("id") Long id);
}
