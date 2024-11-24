package com.fatec.PI3Semestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.PI3Semestre.entity.Disciplina;

/**
 * Interface DisciplinaRepository
 */
@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

    /**
     * Método para deletar disciplina por código
     * @param codDisciplina
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Reserva WHERE cod_turma IN (SELECT cod_turma FROM Turma WHERE cod_curriculo IN (SELECT cod_curriculo FROM Curriculo WHERE cod_disciplina = ?1))", nativeQuery = true)
    void deleteReservasByCodDisciplina(Integer codDisciplina);

    /**
     * Método para deletar disciplina por código
     * @param codDisciplina
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Turma WHERE cod_curriculo IN (SELECT cod_curriculo FROM Curriculo WHERE cod_disciplina = ?1)", nativeQuery = true)
    void deleteTurmasByCodDisciplina(Integer codDisciplina);

    /**
     * Método para deletar disciplina por código
     * @param codDisciplina
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Curriculo WHERE cod_disciplina = ?1", nativeQuery = true)
    void deleteCurriculosByCodDisciplina(Integer codDisciplina);

    /**
     * Método para deletar disciplina por código
     * @param codDisciplina
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Disciplina WHERE cod_disciplina = ?1", nativeQuery = true)
    void deleteDisciplinaByCodDisciplina(Integer codDisciplina);
}