package com.example.ac2p2web.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ac2p2web.models.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByProfessorId(Long professorId);

    List<Agenda> findByCursoId(Long cursoId);

    List<Agenda> findByDataInicio(LocalDate data);

    List<Agenda> findByProfessorIdAndDataInicioBetween(Long professorId, LocalDate dataInicio, LocalDate dataFim);

}
