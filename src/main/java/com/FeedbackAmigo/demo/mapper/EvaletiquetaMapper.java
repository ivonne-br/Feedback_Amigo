package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.EvaletiquetaDto;
import com.FeedbackAmigo.demo.entity.Evaletiqueta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EtiquetaMapper.class, UEAMapper.class})
public interface EvaletiquetaMapper {

    @Mapping(source = "etiqueta", target = "etiqueta")
    @Mapping(source = "ueaEntity", target = "ueaEntity")
    EvaletiquetaDto toDto(Evaletiqueta entity);

    @Mapping(source = "etiqueta", target = "etiqueta")
    @Mapping(source = "ueaEntity", target = "ueaEntity")
    Evaletiqueta toEntity(EvaletiquetaDto dto);
}
