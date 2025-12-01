package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.LicenciaturaDTO;
import com.FeedbackAmigo.demo.entity.Licenciatura;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {LicenciaturaMapper.class})
public interface LicenciaturaMapper {
    LicenciaturaDTO toLicenciaturaDTO(Licenciatura licenciatura);
    Licenciatura toLicenciatura(LicenciaturaDTO licenciaturaDTO);
}
