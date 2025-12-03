
package com.FeedbackAmigo.demo.mapper.impl;

import com.FeedbackAmigo.demo.dto.UEADto;
import com.FeedbackAmigo.demo.entity.UEAEntity;
import com.FeedbackAmigo.demo.mapper.UEAMapper;
import org.springframework.stereotype.Component;

@Component
public class UEAMapperImpl implements UEAMapper {

    @Override
    public UEADto toDTO(UEAEntity entity) {
        UEADto dto = new UEADto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    @Override
    public UEAEntity toEntity(UEADto dto) {
        UEAEntity entity = new UEAEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}

