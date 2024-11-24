package com.fatec.PI3Semestre.controller;

import com.fatec.PI3Semestre.entity.Professor;
import com.fatec.PI3Semestre.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controlador para o recurso Professor
 */
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    /**
     * Injeção de dependência para o serviço de professor
     */
    @Autowired
    private ProfessorService professorService;

    /**
     * Busca todos os professores
     * @return lista de professores
     */
    @GetMapping
    public List<Professor> getAllProfessores() {
        return professorService.findAll();
    }

    /**
     * Busca um professor pelo id
     * @param id do professor
     * @return o professor encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Integer id) {
        Optional<Professor> professor = professorService.findById(id);
        return professor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo professor
     * @param professor a ser criado
     * @return o professor criado
     */
    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor novoProfessor = professorService.save(professor);
        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }

    /**
     * Atualiza um professor
     * @param id do professor a ser atualizado
     * @param professor com os novos dados
     * @return o professor atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Integer id, @RequestBody Professor professor) {
        if (!professorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        professor.setMatriculaProfessor(id);
        Professor professorAtualizado = professorService.save(professor);
        return ResponseEntity.ok(professorAtualizado);
    }

    /**
     * Deleta um professor
     * @param id do professor a ser deletado
     * @return resposta da requisição
     */
    @DeleteMapping("/{professorId}")
    public ResponseEntity<String> deleteProfessorCompleto(@PathVariable Integer professorId) {
        try {
            professorService.deleteProfessorCompleto(professorId);
            return ResponseEntity.ok("Professor e dependências deletados com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body("Erro ao deletar professor: " + e.getMessage());
        }
    }

}
