package com.fatec.PI3Semestre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade Secretaria
 */
@Entity
public class Secretaria {

    // Atributos
    /**
     * Matrícula da secretaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matriculaSecretaria;

    /**
     * Nome da secretaria
     */
    private String nomeSecretaria;

    /**
     * Email da secretaria
     */
    private String emailSecretaria;

    /**
     * Usuario da secretaria
     */
    private String usuario;

    /**
     * Senha da secretaria
     */
    private String senha;

    // Getters e Setters
    public Integer getMatriculaSecretaria() {
        return matriculaSecretaria;
    }

    public void setMatriculaSecretaria(Integer matriculaSecretaria) {
        this.matriculaSecretaria = matriculaSecretaria;
    }

    public String getNomeSecretaria() {
        return nomeSecretaria;
    }

    public void setNomeSecretaria(String nomeSecretaria) {
        this.nomeSecretaria = nomeSecretaria;
    }

    public String getEmailSecretaria() {
        return emailSecretaria;
    }

    public void setEmailSecretaria(String emailSecretaria) {
        this.emailSecretaria = emailSecretaria;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
