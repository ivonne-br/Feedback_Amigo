package com.FeedbackAmigo.demo.mapper.impl;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;
import com.FeedbackAmigo.demo.entity.Pregunta;
import com.FeedbackAmigo.demo.entity.Respuesta;
import com.FeedbackAmigo.demo.entity.RespuestaId;
import com.FeedbackAmigo.demo.mapper.RespuestaMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RespuestaMapperImpl implements RespuestaMapper {


   @Override
   public RespuestaDTO toRespuestaDTO(Respuesta respuesta) {
       RespuestaDTO dto = new RespuestaDTO();
       dto.setIdEvaluacion(respuesta.getId().getIdEvaluacion());
       dto.setIdAlumnoEvaluador(respuesta.getId().getIdAlumnoEvaluador());
       dto.setIdAlumnoEvaluado(respuesta.getId().getIdAlumnoEvaluado());
       dto.setIdUea(respuesta.getId().getIdUea());
       dto.setIdPregunta(respuesta.getId().getIdPregunta());

       dto.setValor(respuesta.getValor());
       return dto;
   }

   @Override
    public Respuesta toRespuesta (RespuestaDTO dto){
       Respuesta respuesta = new Respuesta();

       RespuestaId id = new RespuestaId(
               dto.getIdEvaluacion(),
               dto.getIdAlumnoEvaluador(),
               dto.getIdAlumnoEvaluado(),
               dto.getIdUea(),
               dto.getIdPregunta());

       respuesta.setId(id);
       respuesta.setValor(dto.getValor());
       return respuesta;

   }

}