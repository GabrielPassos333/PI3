package com.fatec.PI3Semestre.service;

import com.fatec.PI3Semestre.entity.Reserva;
import com.fatec.PI3Semestre.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Classe ReservaService
 */
@Service
public class ReservaService {

    /**
     * Atributo reservaRepository
     */
    @Autowired
    private ReservaRepository reservaRepository;

    /**
     * Método findAll
     */
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    /**
     * Método findById
     */
    public Optional<Reserva> findById(Integer id) {
        return reservaRepository.findById(id);
    }

    /**
     * Método save
     */
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    /**
     * Método deleteById
     */
    public void deleteById(Integer id) {
        reservaRepository.deleteById(id);
    }
}
