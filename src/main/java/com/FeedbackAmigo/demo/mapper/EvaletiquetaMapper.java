package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.EvaletiquetaDto;
import com.FeedbackAmigo.demo.entity.Evaletiqueta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EtiquetaMapper.class, UEAMapper.class})
public interface EvaletiquetaMapper {

    @Mapping(source = "idEtiqueta", target = "idEtiqueta")
    @Mapping(source = "idUea", target = "idUea")
    EvaletiquetaDto toDto(Evaletiqueta entity);

    @Mapping(source = "idEtiqueta", target = "idEtiqueta")
    @Mapping(source = "idUea", target = "idUea")
    Evaletiqueta toEntity(EvaletiquetaDto dto);
}
