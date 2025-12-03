package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;
import com.FeedbackAmigo.demo.entity.Respuesta;

public interface RespuestaMapper {
   // Respuesta toRespuesta(RespuestaDTO respuestaDTO);
    RespuestaDTO toRespuestaDTO(Respuesta respuesta);
}
