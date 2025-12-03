package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.UEADto;
import com.FeedbackAmigo.demo.entity.UEA;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UEAMapper {
    UEADto toDto(UEA entity);
    UEA toEntity(UEADto dto);
}
