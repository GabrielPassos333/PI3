package com.fatec.PI3Semestre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade Sala
 */
@Entity
public class Sala {

    // Atributos
    /**
     * Código da sala
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codSala;

    /**
     * Tipo da sala
     */
    private String tipo;

    /**
     * Nome da sala
     */
    private String nomeSala;

    /**
     * Descrição da sala
     */
    private String descricao;

    /**
     * Capacidade da sala
     */
    private Integer capacidade;

    // Getters e Setters
    public Integer getCodSala() {
        return codSala;
    }

    public void setCodSala(Integer codSala) {
        this.codSala = codSala;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}