package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;

import java.util.List;

public interface RespuestaService {

    List<RespuestaDTO> getRespuestas();
    RespuestaDTO getRespuestaById(Long id);
    RespuestaDTO save(RespuestaDTO respuestaDTO);
    RespuestaDTO update(Long id, RespuestaDTO respuestaDTO);
    void delete(Long id);
}
