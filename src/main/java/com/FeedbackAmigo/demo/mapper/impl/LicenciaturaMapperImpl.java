package com.FeedbackAmigo.demo.mapper.impl;

import com.FeedbackAmigo.demo.dto.LicenciaturaDTO;
import com.FeedbackAmigo.demo.entity.Licenciatura;
import com.FeedbackAmigo.demo.mapper.LicenciaturaMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LicenciaturaMapperImpl implements LicenciaturaMapper {
    @Override
    public LicenciaturaDTO toLicenciaturaDTO(Licenciatura licenciatura) {
        LicenciaturaDTO licenciaturaDTO = new LicenciaturaDTO();
        BeanUtils.copyProperties(licenciatura, licenciaturaDTO);
        return licenciaturaDTO;
    }

    @Override
    public Licenciatura toLicenciatura(LicenciaturaDTO licenciaturaDTO) {
        Licenciatura licenciatura = new Licenciatura();
        BeanUtils.copyProperties(licenciaturaDTO, licenciatura);
        return licenciatura;
    }
}
