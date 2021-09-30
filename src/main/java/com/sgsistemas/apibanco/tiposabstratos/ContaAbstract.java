package com.sgsistemas.apibanco.tiposabstratos;

import javax.persistence.*;

@Entity

public abstract class ContaAbstract {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "conta_abs_id")
   private Long id;

   public Long getId() {
      return id;
   }
}
