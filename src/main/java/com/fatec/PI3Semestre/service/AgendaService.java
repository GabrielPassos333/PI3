package com.fatec.PI3Semestre.service;

import com.fatec.PI3Semestre.entity.Agenda;
import com.fatec.PI3Semestre.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Classe AgendaService
 */
@Service
public class AgendaService {

    /**
     * Atributo agendaRepository
     */
    @Autowired
    private AgendaRepository agendaRepository;

    /**
     * Método findAll
     */
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    /**
     * Método findById
     */
    public Optional<Agenda> findById(Integer id) {
        return agendaRepository.findById(id);
    }

    /**
     * Método save
     */
    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    /**
     * Método deleteAgendaById
     */
    @Transactional
    public void deleteAgendaById(Integer agendaId) {
        // Deletar reservas associadas à agenda
        agendaRepository.deleteReservasByCodSala(agendaId);

        // Deletar agenda_sala associada à agenda
        agendaRepository.deleteAgendaSalaByCodSala(agendaId);

        // Deletar a agenda
        agendaRepository.deleteSalaByCodSala(agendaId);
    }
}

