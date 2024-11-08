package com.example.ac2p2web.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.ac2p2web.models.Professor;
import com.example.ac2p2web.services.ProfessorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> listarTodos() {
        return professorService.listarTodos();
    }

    @PostMapping
    public Professor salvar(@RequestBody Professor professor) {
        return professorService.salvar(professor);
    }

    @GetMapping("/{id}")
    public Optional<Professor> encontrarPorId(@PathVariable Long id) {
        return professorService.encontrarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        professorService.deletarPorId(id);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Professor> encontrarPorCurso(@PathVariable Long cursoId) {
        return professorService.encontrarPorCurso(cursoId);
    }
}
