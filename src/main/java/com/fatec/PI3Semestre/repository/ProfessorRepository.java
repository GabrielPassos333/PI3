package com.fatec.PI3Semestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import com.fatec.PI3Semestre.entity.Professor;

/**
 * Interface ProfessorRepository
 */
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    /**
     * Deleta as reservas de um professor
     * @param professorId
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM Reserva r WHERE r.turma IN (SELECT t FROM Turma t WHERE t.professor.matriculaProfessor = :professorId)")
    void deleteReservasByProfessorId(@Param("professorId") Integer professorId);

    /**
     * Deleta as turmas de um professor
     * @param professorId
     */
    @Modifying
    @Query("DELETE FROM Turma t WHERE t.professor.matriculaProfessor = :professorId")
    void deleteTurmasByProfessorId(@Param("professorId") Integer professorId);

    /**
     * Deleta um professor pelo id
     * @param professorId
     */
    @Modifying
    @Query("DELETE FROM Professor p WHERE p.matriculaProfessor = :professorId")
    void deleteProfessorById(@Param("professorId") Integer professorId);

}