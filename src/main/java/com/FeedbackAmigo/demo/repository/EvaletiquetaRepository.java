package com.FeedbackAmigo.demo.repository;


import com.FeedbackAmigo.demo.entity.EvaletiquetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaletiquetaRepository extends JpaRepository<EvaletiquetaEntity.Evaletiqueta, Long> {
    List<EvaletiquetaEntity.Evaletiqueta> findByIdEvaluacion(Long idEvaluacion);
}

