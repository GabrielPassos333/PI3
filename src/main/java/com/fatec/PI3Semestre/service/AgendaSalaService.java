package com.fatec.PI3Semestre.service;

import com.fatec.PI3Semestre.entity.AgendaSala;
import com.fatec.PI3Semestre.repository.AgendaSalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Classe AgendaSalaService
 */
@Service
public class AgendaSalaService {

    /**
     * Atributo agendaSalaRepository
     */
    @Autowired
    private AgendaSalaRepository agendaSalaRepository;

    /**
     * Método findAll
     */
    public List<AgendaSala> findAll() {
        return agendaSalaRepository.findAll();
    }

    /**
     * Método findById
     */
    public Optional<AgendaSala> findById(Integer id) {
        return agendaSalaRepository.findById(id);
    }

    /**
     * Método save
     */
    public AgendaSala save(AgendaSala agendaSala) {
        return agendaSalaRepository.save(agendaSala);
    }

    /**
     * Método deleteById
     */
    @Transactional
    public void deleteById(Integer id) {
        agendaSalaRepository.deleteReservaByCodAgendaSala(id);
        agendaSalaRepository.deleteAgendaSalaByCodAgendaSala(id);
    }
}
