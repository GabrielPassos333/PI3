package com.fatec.PI3Semestre.repository;

import com.fatec.PI3Semestre.entity.AgendaSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface AgendaSalaRepository
 */
@Repository
public interface AgendaSalaRepository extends JpaRepository<AgendaSala, Integer> {

    /**
     * Método deleteAgendaSalaByCodAgendaSala
     */
    @Transactional
    @Modifying
    @Query("delete from AgendaSala a where a.codAgendaSala = :codAgendaSala")
    void deleteAgendaSalaByCodAgendaSala(@Param("codAgendaSala") Integer codAgendaSala);

    /**
     * Método deleteReservaByCodAgendaSala
     */
    @Transactional
    @Modifying
    @Query("delete from Reserva r where r.agendaSala.codAgendaSala = :codAgendaSala")
    void deleteReservaByCodAgendaSala(@Param("codAgendaSala") Integer codAgendaSala);
}
