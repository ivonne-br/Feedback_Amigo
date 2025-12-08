package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.PreguntaDTO;
import com.FeedbackAmigo.demo.entity.Pregunta;

public interface PreguntaMapper {

    PreguntaDTO toPreguntaDTO(Pregunta pregunta);
    Pregunta toPregunta(PreguntaDTO preguntaDTO);
}
