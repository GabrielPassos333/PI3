package com.fatec.PI3Semestre.repository;

import com.fatec.PI3Semestre.entity.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface CurriculoRepository
 */
@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Integer> {
}
