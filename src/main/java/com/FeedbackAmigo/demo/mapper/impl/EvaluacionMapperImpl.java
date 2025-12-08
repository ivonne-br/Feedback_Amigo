package com.FeedbackAmigo.demo.mapper.impl;

import com.FeedbackAmigo.demo.dto.EvaluacionDTO;
import com.FeedbackAmigo.demo.entity.Evaluacion;
import com.FeedbackAmigo.demo.mapper.EvaluacionMapper;
import com.FeedbackAmigo.demo.entity.Alumno;
import com.FeedbackAmigo.demo.entity.UEAEntity;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionMapperImpl implements EvaluacionMapper {

    @Override
    public EvaluacionDTO toEvaluacionDTO(Evaluacion evaluacion) {
        EvaluacionDTO dto = new EvaluacionDTO();

        dto.setIdEvaluacion(evaluacion.getIdEvaluacion());
        dto.setAnonimo(evaluacion.isAnonimo());
        dto.setFechaEvaluacion(evaluacion.getFechaEvaluacion());
        dto.setComentarios(evaluacion.getComentarios());
        dto.setCalificacion(evaluacion.getCalificacion());

        dto.setIdAlumnoEvaluador(evaluacion.getAlumnoEvaluador().getIdAlumno());
        dto.setIdAlumnoEvaluado(evaluacion.getAlumnoEvaluado().getIdAlumno());
        dto.setIdUea(evaluacion.getUea().getId());

        return dto;
    }

    @Override
    public Evaluacion toEvaluacion(EvaluacionDTO dto,
                               Alumno alumnoEvaluador,
                               Alumno alumnoEvaluado,
                               UEAEntity ueaEntity) {

        Evaluacion evaluacion = new Evaluacion();

        evaluacion.setIdEvaluacion(dto.getIdEvaluacion());
        evaluacion.setAnonimo(dto.isAnonimo());
        evaluacion.setFechaEvaluacion(dto.getFechaEvaluacion());
        evaluacion.setComentarios(dto.getComentarios());
        evaluacion.setCalificacion(dto.getCalificacion());

        evaluacion.setAlumnoEvaluador(alumnoEvaluador);
        evaluacion.setAlumnoEvaluado(alumnoEvaluado);
        evaluacion.setUea(ueaEntity);

        return evaluacion;
    }
}


