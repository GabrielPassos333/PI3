package com.fatec.PI3Semestre.repository;

import com.fatec.PI3Semestre.entity.Sala;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface SalaRepository
 */
@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

    /**
     * Método para deletar reservas associadas à sala
     * @param codSala do tipo Integer
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Reserva WHERE cod_agenda_sala IN (SELECT cod_agenda_sala FROM Agenda_Sala WHERE cod_sala = ?1)", nativeQuery = true)
    void deleteReservasByCodSala(Integer codSala);

    /**
     * Método para deletar agenda_sala associada à sala
     * @param codSala do tipo Integer
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Agenda_Sala WHERE cod_sala = ?1", nativeQuery = true)
    void deleteAgendaSalaByCodSala(Integer codSala);

    /**
     * Método para deletar sala pelo código
     * @param codSala do tipo Integer
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Sala WHERE cod_sala = ?1", nativeQuery = true)
    void deleteSalaByCodSala(Integer codSala);
}
