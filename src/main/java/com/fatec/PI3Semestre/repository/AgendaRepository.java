package com.fatec.PI3Semestre.repository;

import com.fatec.PI3Semestre.entity.Agenda;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface AgendaRepository
 */
@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

    /**
     * Método para deletar reservas associadas à agenda
     * @param codSala do tipo Integer
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Reserva WHERE cod_agenda_sala IN (SELECT cod_agenda_sala FROM Agenda_Sala WHERE cod_agenda = ?1)", nativeQuery = true)
    void deleteReservasByCodSala(Integer codSala);

    /**
     * Método para deletar agenda_sala associada à agenda
     * @param codSala do tipo Integer
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Agenda_Sala WHERE cod_agenda = ?1", nativeQuery = true)
    void deleteAgendaSalaByCodSala(Integer codSala);

    /**
     * Método para deletar a agenda
     * @param codSala do tipo Integer
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Agenda WHERE cod_agenda = ?1", nativeQuery = true)
    void deleteSalaByCodSala(Integer codSala);
    
}
