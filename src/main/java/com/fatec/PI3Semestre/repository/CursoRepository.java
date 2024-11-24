package com.fatec.PI3Semestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fatec.PI3Semestre.entity.Curso;

/**
 * Interface CursoRepository
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}