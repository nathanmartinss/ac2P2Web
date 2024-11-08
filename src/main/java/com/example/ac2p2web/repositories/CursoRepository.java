package com.example.ac2p2web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ac2p2web.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByProfessoresId(Long professorId);
}
