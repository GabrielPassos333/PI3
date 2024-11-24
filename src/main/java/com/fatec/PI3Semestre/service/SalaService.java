package com.fatec.PI3Semestre.service;

import com.fatec.PI3Semestre.entity.Sala;
import com.fatec.PI3Semestre.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Classe SalaService
 */
@Service
public class SalaService {

    /**
     * Atributo salaRepository
     */
    @Autowired
    private SalaRepository salaRepository;

    /**
     * Método findAll
     */
    public List<Sala> findAll() {
        return salaRepository.findAll();
    }

    /**
     * Método findById
     */
    public Optional<Sala> findById(Integer id) {
        return salaRepository.findById(id);
    }

    /**
     * Método save
     */
    public Sala save(Sala sala) {
        return salaRepository.save(sala);
    }

    /**
     * Método deleteSalaById
     */
    @Transactional
    public void deleteSalaById(Integer salaId) {
        // Deletar reservas associadas à sala
        salaRepository.deleteReservasByCodSala(salaId);

        // Deletar agenda_sala associada à sala
        salaRepository.deleteAgendaSalaByCodSala(salaId);

        // Deletar a sala
        salaRepository.deleteSalaByCodSala(salaId);
    }
}
