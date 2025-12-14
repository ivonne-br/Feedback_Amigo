package com.FeedbackAmigo.demo.repository;

import com.FeedbackAmigo.demo.entity.Respuesta;
import com.FeedbackAmigo.demo.entity.RespuestaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, RespuestaId> {

    List<Respuesta> findByIdIdEvaluacion(Long idEvaluacion);
}
