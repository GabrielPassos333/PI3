package com.fatec.PI3Semestre.service;

import com.fatec.PI3Semestre.entity.Professor;
import com.fatec.PI3Semestre.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Classe ProfessorService
 */
@Service
public class ProfessorService {

    /**
     * Atributo professorRepository
     */
    @Autowired
    private ProfessorRepository professorRepository;

    /**
     * Método findAll do ProfessorService
     */
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    /**
     * Método findById do ProfessorService
     */
    public Optional<Professor> findById(Integer id) {
        return professorRepository.findById(id);
    }

    /**
     * Método save do ProfessorService
     */
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

     /**
     * Método deleteProfessorCompleto do ProfessorService
     */
    @Transactional
    public void deleteProfessorCompleto(Integer professorId) {
        // Verifica se professor existe
        /*Professor professor = professorRepository.findById(professorId)
            .orElseThrow(() -> new RuntimeException("Professor não encontrado"));*/

        // 1. Deleta as reservas primeiro
        professorRepository.deleteReservasByProfessorId(professorId);
        
        // 2. Deleta as turmas
        professorRepository.deleteTurmasByProfessorId(professorId);
        
        // 3. Por fim, deleta o professor
        professorRepository.deleteProfessorById(professorId);
    }
}
