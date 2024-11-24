package com.fatec.PI3Semestre.repository;

import com.fatec.PI3Semestre.entity.Secretaria;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface SecretariaRepository
 */
@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Integer> {

  @Transactional
  @Modifying
  @Query("DELETE FROM Reserva r WHERE r.secretaria.matriculaSecretaria = :matriculaSecretaria")
  void deleteReservasBySecretaria(Integer matriculaSecretaria);

  @Transactional
  @Modifying
  @Query("DELETE FROM Secretaria s WHERE s.matriculaSecretaria = :matriculaSecretaria")
  void deleteSecretariaById(Integer matriculaSecretaria);

}
