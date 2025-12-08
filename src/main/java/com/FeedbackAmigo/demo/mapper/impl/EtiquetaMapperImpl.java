package com.FeedbackAmigo.demo.mapper.impl;

import com.FeedbackAmigo.demo.dto.EtiquetaDTO;
import com.FeedbackAmigo.demo.entity.Etiqueta;
import com.FeedbackAmigo.demo.mapper.EtiquetaMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EtiquetaMapperImpl implements EtiquetaMapper {

    @Override
    public EtiquetaDTO toEtiquetaDTO(Etiqueta etiqueta) {
        EtiquetaDTO etiquetaDTO = new EtiquetaDTO();
        BeanUtils.copyProperties(etiqueta, etiquetaDTO);
        return etiquetaDTO;
    }

    @Override
    public Etiqueta toEtiqueta(EtiquetaDTO etiquetaDTO) {
        Etiqueta etiqueta = new Etiqueta();
        BeanUtils.copyProperties(etiquetaDTO, etiqueta);
        return etiqueta;
    }
}
