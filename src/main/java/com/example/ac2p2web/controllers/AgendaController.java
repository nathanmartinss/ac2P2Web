package com.example.ac2p2web.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.ac2p2web.models.Agenda;
import com.example.ac2p2web.services.AgendaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public List<Agenda> listarTodos() {
        return agendaService.listarTodos();
    }

    @PostMapping
    public Agenda salvar(@RequestBody Agenda agenda) {
        return agendaService.salvar(agenda);
    }

    @GetMapping("/{id}")
    public Optional<Agenda> encontrarPorId(@PathVariable Long id) {
        return agendaService.encontrarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        agendaService.deletarPorId(id);
    }

    @GetMapping("/professor/{professorId}")
    public List<Agenda> encontrarPorProfessor(@PathVariable Long professorId) {
        return agendaService.encontrarPorProfessor(professorId);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Agenda> encontrarPorCurso(@PathVariable Long cursoId) {
        return agendaService.encontrarPorCurso(cursoId);
    }

    @GetMapping("/data/{data}")
    public List<Agenda> encontrarPorData(@PathVariable LocalDate data) {
        return agendaService.encontrarPorData(data);
    }

    @GetMapping("/disponibilidade/{professorId}/{dataInicio}/{dataFim}")
    public boolean verificarDisponibilidadeProfessor(@PathVariable Long professorId,
            @PathVariable LocalDate dataInicio,
            @PathVariable LocalDate dataFim) {
        return agendaService.verificarDisponibilidadeProfessor(professorId, dataInicio, dataFim);
    }

    @GetMapping("/resumo/{agendaId}")
    public String gerarResumo(@PathVariable Long agendaId) {
        return agendaService.gerarResumo(agendaId);
    }
}
