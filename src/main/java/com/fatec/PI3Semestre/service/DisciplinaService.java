package com.fatec.PI3Semestre.service;

import com.fatec.PI3Semestre.entity.Disciplina;
import com.fatec.PI3Semestre.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Classe DisciplinaService
 */
@Service
public class DisciplinaService {

    /**
     * Atributo disciplinaRepository
     */
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    /**
     * Método findAll do DisciplinaService
     */
    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    /**
     * Método findById do DisciplinaService
     */
    public Optional<Disciplina> findById(Integer id) {
        return disciplinaRepository.findById(id);
    }

    /**
     * Método save do DisciplinaService
     */
    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }
    
    /**
     * Método deleteDisciplinaById do DisciplinaService
     */
    @Transactional
    public void deleteDisciplinaById(Integer disciplinaId) {
        // Deletar reservas associadas à disciplina
        disciplinaRepository.deleteReservasByCodDisciplina(disciplinaId);

        // Deletar turmas associadas à disciplina
        disciplinaRepository.deleteTurmasByCodDisciplina(disciplinaId);

        // Deletar currículos associados à disciplina
        disciplinaRepository.deleteCurriculosByCodDisciplina(disciplinaId);

        // Deletar a disciplina
        disciplinaRepository.deleteDisciplinaByCodDisciplina(disciplinaId);
    }
}