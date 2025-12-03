package com.FeedbackAmigo.demo.repository;



import com.FeedbackAmigo.demo.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}
