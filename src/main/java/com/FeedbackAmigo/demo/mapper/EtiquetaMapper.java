package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.EtiquetaDTO;
import com.FeedbackAmigo.demo.entity.Etiqueta;

public interface EtiquetaMapper {
    EtiquetaDTO toEtiquetaDTO(Etiqueta etiqueta);
    Etiqueta toEtiqueta(EtiquetaDTO etiquetaDTO);
}
