package com.example.ac2p2web.services;

import java.util.List;
import java.util.Optional;

import com.example.ac2p2web.models.Curso;

public interface CursoService {
    List<Curso> listarTodos();

    Curso salvar(Curso curso);

    Optional<Curso> encontrarPorId(Long id);

    void deletarPorId(Long id);

    List<Curso> encontrarPorProfessor(Long professorId);
}
