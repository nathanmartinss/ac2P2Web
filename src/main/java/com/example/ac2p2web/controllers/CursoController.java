package com.example.ac2p2web.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.ac2p2web.models.Curso;
import com.example.ac2p2web.services.CursoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> listarTodos() {
        return cursoService.listarTodos();
    }

    @PostMapping
    public Curso salvar(@RequestBody Curso curso) {
        return cursoService.salvar(curso);
    }

    @GetMapping("/{id}")
    public Optional<Curso> encontrarPorId(@PathVariable Long id) {
        return cursoService.encontrarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        cursoService.deletarPorId(id);
    }

    @GetMapping("/professor/{professorId}")
    public List<Curso> encontrarPorProfessor(@PathVariable Long professorId) {
        return cursoService.encontrarPorProfessor(professorId);
    }
}
