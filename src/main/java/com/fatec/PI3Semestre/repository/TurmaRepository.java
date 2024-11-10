package com.fatec.PI3Semestre.repository;

import com.fatec.PI3Semestre.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface TurmaRepository
 */
@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
