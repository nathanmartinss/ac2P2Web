package com.example.ac2p2web.services;

import org.springframework.stereotype.Service;

import com.example.ac2p2web.models.Agenda;
import com.example.ac2p2web.repositories.AgendaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public List<Agenda> listarTodos() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda salvar(Agenda agenda) {
        if (verificarDisponibilidadeProfessorCurso(agenda.getProfessor().getId(), agenda.getCurso().getId(),
                agenda.getDataInicio(), agenda.getDataFim())) {
            return agendaRepository.save(agenda);
        } else {
            throw new IllegalArgumentException("Professor já alocado para outro curso no mesmo horário.");
        }
    }

    @Override
    public Optional<Agenda> encontrarPorId(Long id) {
        return agendaRepository.findById(id);
    }

    @Override
    public void deletarPorId(Long id) {
        agendaRepository.deleteById(id);
    }

    @Override
    public List<Agenda> encontrarPorProfessor(Long professorId) {
        return agendaRepository.findByProfessorId(professorId);
    }

    @Override
    public List<Agenda> encontrarPorCurso(Long cursoId) {
        return agendaRepository.findByCursoId(cursoId);
    }

    @Override
    public List<Agenda> encontrarPorData(LocalDate data) {
        return agendaRepository.findByDataInicio(data);
    }

    @Override
    public boolean verificarDisponibilidadeProfessor(Long professorId, LocalDate dataInicio, LocalDate dataFim) {
        List<Agenda> agendas = agendaRepository.findByProfessorIdAndDataInicioBetween(professorId, dataInicio, dataFim);
        return agendas.isEmpty();
    }

    @Override
    public boolean verificarDisponibilidadeProfessorCurso(Long professorId, Long cursoId, LocalDate dataInicio,
            LocalDate dataFim) {
        List<Agenda> agendas = agendaRepository.findByProfessorIdAndDataInicioBetween(professorId, dataInicio, dataFim);
        for (Agenda agenda : agendas) {
            if (agenda.getCurso().getId().equals(cursoId)
                    || agenda.getCurso().getDescricao().equals(agenda.getCurso().getDescricao())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String gerarResumo(Long agendaId) {
        Optional<Agenda> agendaOpt = agendaRepository.findById(agendaId);
        if (agendaOpt.isPresent()) {
            Agenda agenda = agendaOpt.get();
            return String.format("Resumo do treinamento: %s, realizado por %s entre %s e %s.",
                    agenda.getCurso().getDescricao(), agenda.getProfessor().getNome(), agenda.getDataInicio(),
                    agenda.getDataFim());
        } else {
            return "Agenda não encontrada.";
        }
    }
}
