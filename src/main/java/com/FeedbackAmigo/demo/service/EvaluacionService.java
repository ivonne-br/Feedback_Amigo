package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.EvaluacionDTO;
import com.FeedbackAmigo.demo.dto.PreguntaDTO;

import java.util.List;

public interface EvaluacionService {

    List<EvaluacionDTO> getEvaluaciones();
    EvaluacionDTO getEvaluacionById(Long id);
    EvaluacionDTO save(EvaluacionDTO dto);
    EvaluacionDTO update(Long id, EvaluacionDTO dto);
    void delete(Long id);
}
