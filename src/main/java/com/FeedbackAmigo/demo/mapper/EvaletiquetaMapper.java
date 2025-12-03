package com.FeedbackAmigo.demo.mapper;


import com.FeedbackAmigo.demo.dto.EvaletiquetaDto;
import com.FeedbackAmigo.demo.entity.Evaletiqueta;

public interface EvaletiquetaMapper {
    EvaletiquetaDto toDto(Evaletiqueta entity);
    Evaletiqueta toEntity(EvaletiquetaDto dto);

}