package com.fatec.PI3Semestre.service;

import com.fatec.PI3Semestre.entity.Turma;
import com.fatec.PI3Semestre.repository.TurmaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe TurmaService
 */
@Service
public class TurmaService {

    /**
     * Atributo turmaRepository
     */
    @Autowired
    private TurmaRepository turmaRepository;

    /**
     * Método findAll
     */
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    /**
     * Método findById
     */
    public Optional<Turma> findById(Integer id) {
        return turmaRepository.findById(id);
    }

    /**
     * Método save
     */
    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    /**
     * Método deleteById
     */
    public void deleteById(Integer id) {
        turmaRepository.deleteById(id);
    }

    /**
     * Método deleteTurmaAndReservas
     */
    @Transactional
    public void deleteTurma(Integer codTurma) {
        turmaRepository.deleteReservaByCodTurma(codTurma);
        turmaRepository.deleteTurmaByCodTurma(codTurma);
    }
}
