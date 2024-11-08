package com.example.ac2p2web.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.ac2p2web.models.Agenda;

public interface AgendaService {
    List<Agenda> listarTodos();

    Agenda salvar(Agenda agenda);

    Optional<Agenda> encontrarPorId(Long id);

    void deletarPorId(Long id);

    List<Agenda> encontrarPorProfessor(Long professorId);

    List<Agenda> encontrarPorCurso(Long cursoId);

    List<Agenda> encontrarPorData(LocalDate data);

    boolean verificarDisponibilidadeProfessor(Long professorId, LocalDate dataInicio, LocalDate dataFim);

    boolean verificarDisponibilidadeProfessorCurso(Long professorId, Long cursoId, LocalDate dataInicio,
            LocalDate dataFim);

    String gerarResumo(Long agendaId);
}
