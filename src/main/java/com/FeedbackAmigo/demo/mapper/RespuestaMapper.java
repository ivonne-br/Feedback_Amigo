package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;
import com.FeedbackAmigo.demo.entity.Respuesta;

public interface RespuestaMapper {

    RespuestaDTO toRespuestaDTO(Respuesta respuesta);
    Respuesta toRespuesta (RespuestaDTO dto);
}
