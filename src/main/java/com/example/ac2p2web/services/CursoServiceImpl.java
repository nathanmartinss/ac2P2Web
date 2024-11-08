package com.example.ac2p2web.services;

import org.springframework.stereotype.Service;

import com.example.ac2p2web.models.Curso;
import com.example.ac2p2web.repositories.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Optional<Curso> encontrarPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public void deletarPorId(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public List<Curso> encontrarPorProfessor(Long professorId) {
        return cursoRepository.findByProfessoresId(professorId);
    }
}
