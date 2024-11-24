package com.fatec.PI3Semestre.repository;

import com.fatec.PI3Semestre.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface TurmaRepository
 */
@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

  /**
   * Deleta as reservas de uma turma
   * @param codTurma
   */
  @Modifying
  @Transactional
  @Query("DELETE FROM Reserva r WHERE r.turma.codTurma = :codTurma")
  void deleteReservaByCodTurma(Integer codTurma);
    
  /**
   * Deleta uma turma pelo id
  * @param codTurma
  */
  @Modifying
  @Transactional
  @Query("DELETE FROM Turma t WHERE t.codTurma = :codTurma")
  void deleteTurmaByCodTurma(Integer codTurma);
}
