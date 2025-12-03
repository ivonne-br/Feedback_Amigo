package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.PreguntaDTO;

import java.util.List;

public interface PreguntaService {

     List<PreguntaDTO> getPreguntas();
     PreguntaDTO getPreguntaById(Long id);
     PreguntaDTO save(PreguntaDTO preguntaDTO);
     PreguntaDTO update(Long id, PreguntaDTO preguntaDTO );
     void delete(Long id);
}
