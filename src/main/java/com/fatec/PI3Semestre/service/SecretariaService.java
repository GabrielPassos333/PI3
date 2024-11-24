package com.fatec.PI3Semestre.service;

import com.fatec.PI3Semestre.entity.Secretaria;
import com.fatec.PI3Semestre.repository.SecretariaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Classe SecretariaService
 */
@Service
public class SecretariaService {

    /**
     * Atributo secretariaRepository
     */
    @Autowired
    private SecretariaRepository secretariaRepository;

    /**
     * Método findAll do SecretariaService
     */
    public List<Secretaria> findAll() {
        return secretariaRepository.findAll();
    }

    /**
     * Método findById do SecretariaService
     */
    public Optional<Secretaria> findById(Integer id) {
        return secretariaRepository.findById(id);
    }

    /**
     * Método save do SecretariaService
     */
    public Secretaria save(Secretaria secretaria) {
        return secretariaRepository.save(secretaria);
    }

    /**
     * Método deleteById do SecretariaService
     */
    public void deleteById(Integer id) {
        secretariaRepository.deleteById(id);
    }

    /**
     * Exclui uma secretaria e todas as reservas associadas.
     * @param matriculaSecretaria ID da secretaria.
     */
    @Transactional
    public void deleteSecretariaAndDependencies(Integer matriculaSecretaria) {
        // Passo 1: Excluir reservas associadas à secretaria
        secretariaRepository.deleteReservasBySecretaria(matriculaSecretaria);

        // Passo 2: Excluir a secretaria
        secretariaRepository.deleteSecretariaById(matriculaSecretaria);
    }
}
