package com.FeedbackAmigo.demo.mapper.impl;

import com.FeedbackAmigo.demo.dto.PreguntaDTO;
import com.FeedbackAmigo.demo.entity.Pregunta;
import com.FeedbackAmigo.demo.mapper.PreguntaMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PreguntaMapperImpl  implements PreguntaMapper {

    @Override
    public PreguntaDTO toPreguntaDTO(Pregunta pregunta){
        PreguntaDTO preguntaDTO = new PreguntaDTO();
        BeanUtils.copyProperties(pregunta, preguntaDTO);
        return preguntaDTO;
    }

    @Override
    public Pregunta toPregunta(PreguntaDTO preguntaDTO){
        Pregunta pregunta = new Pregunta();
        BeanUtils.copyProperties(preguntaDTO, pregunta);
        return pregunta;
    }
}
