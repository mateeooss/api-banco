package com.sgsistemas.apibanco.registro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    @Query(nativeQuery = true, value = "select * from REGISTRO where CONTA_ID = :id  AND TIPO_DEMOVIMENTACAO  = 3 AND SITUACAO = FALSE")
    List<Registro> listarCreditosPendentes(@Param("id") Long id);
}
