package com.FeedbackAmigo.demo.repository;

import com.FeedbackAmigo.demo.entity.Respuesta;
import com.FeedbackAmigo.demo.entity.RespuestaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, RespuestaId> {
}
