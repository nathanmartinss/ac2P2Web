package com.example.ac2p2web.services;

import org.springframework.stereotype.Service;

import com.example.ac2p2web.models.Professor;
import com.example.ac2p2web.repositories.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    @Override
    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Optional<Professor> encontrarPorId(Long id) {
        return professorRepository.findById(id);
    }

    @Override
    public void deletarPorId(Long id) {
        professorRepository.deleteById(id);
    }

    @Override
    public List<Professor> encontrarPorCurso(Long cursoId) {
        return professorRepository.findByCursosId(cursoId);
    }
}
