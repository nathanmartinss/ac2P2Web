package com.example.ac2p2web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ac2p2web.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findByCursosId(Long cursoId);
}
