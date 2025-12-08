package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;
import com.FeedbackAmigo.demo.entity.RespuestaId;

import java.util.List;


public interface RespuestaService {

    List<RespuestaDTO> getRespuestas();
    RespuestaDTO getRespuestaById(RespuestaId id);
    RespuestaDTO save(RespuestaDTO dto);
    RespuestaDTO update(RespuestaId id, RespuestaDTO dto);
    void delete(RespuestaId id);
}

/*public interface RespuestaService {

    List<RespuestaDTO> getRespuestas();
    RespuestaDTO getRespuestaById(Long id);
    RespuestaDTO save(RespuestaDTO respuestaDTO);
    RespuestaDTO update(Long id, RespuestaDTO respuestaDTO);
    void delete(Long id);
}*/

