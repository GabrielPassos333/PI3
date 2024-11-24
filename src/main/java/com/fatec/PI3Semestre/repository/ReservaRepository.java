package com.fatec.PI3Semestre.repository;

import com.fatec.PI3Semestre.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface ReservaRepository
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
