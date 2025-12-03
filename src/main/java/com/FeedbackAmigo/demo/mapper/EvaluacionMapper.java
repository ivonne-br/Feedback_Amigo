package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.EvaluacionDTO;
import com.FeedbackAmigo.demo.entity.Alumno;
import com.FeedbackAmigo.demo.entity.Evaluacion;
import com.FeedbackAmigo.demo.entity.UEAEntity;

public interface EvaluacionMapper {

    EvaluacionDTO toEvaluacionDTO(Evaluacion evaluacion);
     Evaluacion toEvaluacion(EvaluacionDTO dto,
                               Alumno alumnoEvaluador,
                               Alumno alumnoEvaluado,
                               UEAEntity uea);

}
