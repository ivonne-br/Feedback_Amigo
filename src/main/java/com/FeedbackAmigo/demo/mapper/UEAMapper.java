package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.UEADto;
import com.FeedbackAmigo.demo.entity.UEAEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UEAMapper {
    UEADto toDto(UEAEntity entity);
    UEAEntity toEntity(UEADto dto);
}
