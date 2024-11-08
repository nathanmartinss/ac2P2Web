package com.example.ac2p2web.services;

import java.util.List;
import java.util.Optional;

import com.example.ac2p2web.models.Professor;

public interface ProfessorService {
    List<Professor> listarTodos();

    Professor salvar(Professor professor);

    Optional<Professor> encontrarPorId(Long id);

    void deletarPorId(Long id);

    List<Professor> encontrarPorCurso(Long cursoId);
}
