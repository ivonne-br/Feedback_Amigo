package com.FeedbackAmigo.demo.mapper;


import com.FeedbackAmigo.demo.dto.EvaletiquetaDto;
import com.FeedbackAmigo.demo.entity.EvaletiquetaEntity;

public interface EvaletiquetaMapper {
    EvaletiquetaDto toDto(EvaletiquetaEntity.Evaletiqueta entity);
    EvaletiquetaEntity.Evaletiqueta toEntity(EvaletiquetaDto dto);

    EvaletiquetaDto toDto(EvaletiquetaEntity entity);

}
