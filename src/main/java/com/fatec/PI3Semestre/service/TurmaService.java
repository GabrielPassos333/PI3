package com.fatec.PI3Semestre.service;

import com.fatec.PI3Semestre.entity.Turma;
import com.fatec.PI3Semestre.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço de Turma
 */
@Service
public class TurmaService {

    /**
     * Repositório de Turma
     */
    @Autowired
    private TurmaRepository turmaRepository;

    /**
     * Busca todas as turmas
     * @return Lista de turmas
     */
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    /**
     * Busca uma turma por ID
     * @param id ID da turma
     * @return Turma
     */
    public Optional<Turma> findById(Integer id) {
        return turmaRepository.findById(id);
    }

    /**
     * Salva uma turma
     * @param turma Turma
     * @return Turma salva
     */
    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    /**
     * Deleta uma turma por ID
     * @param id ID da turma
     */
    public void deleteById(Integer id) {
        turmaRepository.deleteById(id);
    }
}
