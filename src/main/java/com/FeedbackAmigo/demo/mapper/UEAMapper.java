package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.UEADto;
import com.FeedbackAmigo.demo.entity.UEAEntity;

public interface UEAMapper {
    UEADto toDTO(UEAEntity entity);
    UEAEntity toEntity(UEADto dto);
}
