package com.FeedbackAmigo.demo.service;


import com.FeedbackAmigo.demo.dto.EvaletiquetaDto;

import java.util.List;

public interface EvaletiquetaService {
    EvaletiquetaDto save(EvaletiquetaDto dto);
    List<EvaletiquetaDto> findByEvaluacion(Long idEvaluacion);
}
