package com.example.ac2p2web.models;

import lombok.Data;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String cargaHoraria;
    private String objetivos;
    private String ementa;

    @ManyToMany(mappedBy = "cursos")
    private List<Professor> professores;
}
