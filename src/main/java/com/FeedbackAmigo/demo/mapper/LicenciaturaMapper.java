package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.LicenciaturaDTO;
import com.FeedbackAmigo.demo.entity.Licenciatura;

public interface LicenciaturaMapper {
    LicenciaturaDTO toLicenciaturaDTO(Licenciatura licenciatura);
    Licenciatura toLicenciatura(LicenciaturaDTO licenciaturaDTO);
}
