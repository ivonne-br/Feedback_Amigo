package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.EvaletiquetaDto;
import java.util.List;

public interface EvaletiquetaService {
    EvaletiquetaDto save(EvaletiquetaDto dto);
    List<EvaletiquetaDto> findAll();
    EvaletiquetaDto findById(Long id);
    void delete(Long id);

    List<EvaletiquetaDto> findByAlumnoEvaluado(Long idAlumnoEvaluado);
    List<EvaletiquetaDto> findByAlumnoEvaluador(Long idAlumnoEvaluador);
    List<EvaletiquetaDto> findByUea(Long idUea);
    List<EvaletiquetaDto> findByEvaluacion(Long idEvaluacion);
}
