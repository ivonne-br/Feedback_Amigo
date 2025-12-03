package com.FeedbackAmigo.demo.repository;

import com.FeedbackAmigo.demo.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
