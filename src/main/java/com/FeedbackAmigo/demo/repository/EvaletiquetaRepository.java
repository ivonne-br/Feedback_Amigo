package com.FeedbackAmigo.demo.repository;


import com.FeedbackAmigo.demo.entity.Evaletiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaletiquetaRepository extends JpaRepository<Evaletiqueta, Long> {
    List<Evaletiqueta> findByIdEvaluacion(Long idEvaluacion);
}

