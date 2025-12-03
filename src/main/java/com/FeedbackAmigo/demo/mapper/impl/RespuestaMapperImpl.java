package com.FeedbackAmigo.demo.mapper.impl;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;
import com.FeedbackAmigo.demo.entity.Pregunta;
import com.FeedbackAmigo.demo.entity.Respuesta;
import com.FeedbackAmigo.demo.mapper.RespuestaMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RespuestaMapperImpl implements RespuestaMapper {

   /* @Override
    public RespuestaDTO toRespuestaDTO(Respuesta respuesta) {
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        BeanUtils.copyProperties(respuesta, respuestaDTO);
        return respuestaDTO;

    }*/
   @Override
   public RespuestaDTO toRespuestaDTO(Respuesta respuesta) {
       RespuestaDTO dto = new RespuestaDTO();
       dto.setIdRespuesta(respuesta.getIdRespuesta());
       dto.setValor(respuesta.getValor());
       dto.setIdPregunta(respuesta.getPregunta().getIdPregunta());
       dto.setIdEvaluacion(respuesta.getEvaluacion().getIdEvaluacion());
       return dto;
   }
   /* @Override
    public Respuesta toRespuesta(RespuestaDTO respuestaDTO) {
        Respuesta respuesta = new Respuesta();
        BeanUtils.copyProperties(respuestaDTO, respuesta);
        return respuesta;
    } */
}