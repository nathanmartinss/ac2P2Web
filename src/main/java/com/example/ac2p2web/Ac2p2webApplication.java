package com.example.ac2p2web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac2p2web.models.Agenda;
import com.example.ac2p2web.models.Curso;
import com.example.ac2p2web.models.Professor;
import com.example.ac2p2web.repositories.AgendaRepository;
import com.example.ac2p2web.repositories.CursoRepository;
import com.example.ac2p2web.repositories.ProfessorRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class Ac2p2webApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ac2p2webApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ProfessorRepository professorRepository,
			CursoRepository cursoRepository,
			AgendaRepository agendaRepository) {
		return (args) -> {

			// Inserção de Cursos
			Curso curso1 = new Curso();
			curso1.setDescricao("Fisioterapia xyz");
			curso1.setCargaHoraria("40 horas");
			curso1.setObjetivos("Objetivo do curso 1");
			curso1.setEmenta("Ementa do curso 1");

			Curso curso2 = new Curso();
			curso2.setDescricao("Fisioterapia inicial");
			curso2.setCargaHoraria("20 horas");
			curso2.setObjetivos("Objetivo do curso 2");
			curso2.setEmenta("Ementa do curso 2");

			Curso curso3 = new Curso();
			curso3.setDescricao("Abordagens terapêuticas");
			curso3.setCargaHoraria("30 horas");
			curso3.setObjetivos("Objetivo do curso 3");
			curso3.setEmenta("Ementa do curso 3");

			cursoRepository.save(curso1);
			cursoRepository.save(curso2);
			cursoRepository.save(curso3);

			// Inserção de Professores
			Professor professor1 = new Professor();
			professor1.setNome("Arnaldo César");
			professor1.setCpf("12345678900");
			professor1.setRg("1234567");
			professor1.setEndereco("Rua A, 123");
			professor1.setCelular("11999998888");
			professor1.setCursos(List.of(curso1, curso2));

			Professor professor2 = new Professor();
			professor2.setNome("Marcelo Alberto");
			professor2.setCpf("09876543211");
			professor2.setRg("7654321");
			professor2.setEndereco("Rua B, 456");
			professor2.setCelular("11988887777");
			professor2.setCursos(List.of(curso2, curso3));

			Professor professor3 = new Professor();
			professor3.setNome("Maria Cavalcante");
			professor3.setCpf("11223344556");
			professor3.setRg("1233214");
			professor3.setEndereco("Rua C, 789");
			professor3.setCelular("11977776666");
			professor3.setCursos(List.of(curso1, curso3));

			professorRepository.save(professor1);
			professorRepository.save(professor2);
			professorRepository.save(professor3);

			// Inserção de Agendas
			Agenda agenda1 = new Agenda();
			agenda1.setCurso(curso1);
			agenda1.setDataInicio(LocalDate.of(2024, 3, 17));
			agenda1.setDataFim(LocalDate.of(2024, 3, 20));
			agenda1.setHorarioInicio(LocalTime.of(8, 0));
			agenda1.setHorarioFim(LocalTime.of(17, 0));
			agenda1.setProfessor(professor1);
			agenda1.setCidade("Marília");
			agenda1.setEstado("SP");
			agenda1.setCep("123321");

			Agenda agenda2 = new Agenda();
			agenda2.setCurso(curso2);
			agenda2.setDataInicio(LocalDate.of(2024, 3, 17));
			agenda2.setDataFim(LocalDate.of(2024, 3, 19));
			agenda2.setHorarioInicio(LocalTime.of(8, 0));
			agenda2.setHorarioFim(LocalTime.of(17, 0));
			agenda2.setProfessor(professor2);
			agenda2.setCidade("Sorocaba");
			agenda2.setEstado("SP");
			agenda2.setCep("18050000");

			Agenda agenda3 = new Agenda();
			agenda3.setCurso(curso3);
			agenda3.setDataInicio(LocalDate.of(2024, 3, 19));
			agenda3.setDataFim(LocalDate.of(2024, 3, 21));
			agenda3.setHorarioInicio(LocalTime.of(8, 0));
			agenda3.setHorarioFim(LocalTime.of(12, 0));
			agenda3.setProfessor(professor3);
			agenda3.setCidade("Jundiaí");
			agenda3.setEstado("SP");
			agenda3.setCep("1700000");

			Agenda agenda4 = new Agenda();
			agenda4.setCurso(curso1);
			agenda4.setDataInicio(LocalDate.of(2024, 3, 21));
			agenda4.setDataFim(LocalDate.of(2024, 3, 22));
			agenda4.setHorarioInicio(LocalTime.of(8, 0));
			agenda4.setHorarioFim(LocalTime.of(18, 0));
			agenda4.setProfessor(professor1);
			agenda4.setCidade("São Roque");
			agenda4.setEstado("SP");
			agenda4.setCep("18040000");

			Agenda agenda5 = new Agenda();
			agenda5.setCurso(curso2);
			agenda5.setDataInicio(LocalDate.of(2024, 3, 22));
			agenda5.setDataFim(LocalDate.of(2024, 3, 24));
			agenda5.setHorarioInicio(LocalTime.of(8, 0));
			agenda5.setHorarioFim(LocalTime.of(17, 0));
			agenda5.setProfessor(professor2);
			agenda5.setCidade("Campinas");
			agenda5.setEstado("SP");
			agenda5.setCep("1300000");

			agendaRepository.save(agenda1);
			agendaRepository.save(agenda2);
			agendaRepository.save(agenda3);
			agendaRepository.save(agenda4);
			agendaRepository.save(agenda5);
		};
	}
}
