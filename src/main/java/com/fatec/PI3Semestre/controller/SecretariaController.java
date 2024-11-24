package com.fatec.PI3Semestre.controller;

import com.fatec.PI3Semestre.entity.Secretaria;
import com.fatec.PI3Semestre.service.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por controlar as requisições referentes a Secretaria
 */
@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

    /**
     * Atributo secretariaService do tipo SecretariaService
     */
    @Autowired
    private SecretariaService secretariaService;

    /**
     * Método para listar todas as secretarias
     * @return List<Secretaria>
     */
    @GetMapping
    public List<Secretaria> getAllSecretarias() {
        return secretariaService.findAll();
    }

    /**
     * Método para buscar uma secretaria pelo id
     * @param id do tipo Integer
     * @return ResponseEntity<Secretaria>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Secretaria> getSecretariaById(@PathVariable Integer id) {
        Optional<Secretaria> secretaria = secretariaService.findById(id);
        return secretaria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Método para criar uma nova secretaria
     * @param secretaria do tipo Secretaria
     * @return ResponseEntity<Secretaria>
     */
    @PostMapping
    public ResponseEntity<Secretaria> createSecretaria(@RequestBody Secretaria secretaria) {
        Secretaria novaSecretaria = secretariaService.save(secretaria);
        return new ResponseEntity<>(novaSecretaria, HttpStatus.CREATED);
    }

    /**
     * Método para atualizar uma secretaria
     * @param id do tipo Integer
     * @param secretaria do tipo Secretaria
     * @return ResponseEntity<Secretaria>
     */
    @PutMapping("/{id}")
    public ResponseEntity<Secretaria> updateSecretaria(@PathVariable Integer id, @RequestBody Secretaria secretaria) {
        if (!secretariaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        secretaria.setMatriculaSecretaria(id);
        Secretaria secretariaAtualizada = secretariaService.save(secretaria);
        return ResponseEntity.ok(secretariaAtualizada);
    }

    /**
     * Método para excluir uma secretaria e suas dependências.
     * @param matriculaSecretaria ID da secretaria a ser excluída.
     * @return ResponseEntity com status OK ou NOT_FOUND.
     */
    @DeleteMapping("/{matriculaSecretaria}")
    public ResponseEntity<Void> deleteSecretariaAndDependencies(@PathVariable Integer matriculaSecretaria) {
        try {
            secretariaService.deleteSecretariaAndDependencies(matriculaSecretaria);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
