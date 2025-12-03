package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.EtiquetaDTO;

import java.util.List;

public interface EtiquetaService {
    List<EtiquetaDTO> getEtiquetas();
    EtiquetaDTO getEtiquetaById(Long id);
    EtiquetaDTO save(EtiquetaDTO etiquetaDTO);
    EtiquetaDTO update(Long id, EtiquetaDTO etiquetaDTO);
    void delete(Long id);

}
