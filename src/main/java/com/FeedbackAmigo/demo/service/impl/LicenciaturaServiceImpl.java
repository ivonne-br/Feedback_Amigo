package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.LicenciaturaDTO;
import com.FeedbackAmigo.demo.entity.Licenciatura;
import com.FeedbackAmigo.demo.mapper.LicenciaturaMapper;
import com.FeedbackAmigo.demo.repository.LicenciaturaRepository;
import com.FeedbackAmigo.demo.service.LicenciaturaService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LicenciaturaServiceImpl implements LicenciaturaService {
    private final LicenciaturaMapper licenciaturaMapper;
    private final LicenciaturaRepository licenciaturaRepository;

    public LicenciaturaServiceImpl(LicenciaturaMapper licenciaturaMapper, LicenciaturaRepository licenciaturaRepository) {
        this.licenciaturaMapper = licenciaturaMapper;
        this.licenciaturaRepository = licenciaturaRepository;
    }

    @Override
    public List<LicenciaturaDTO> findAll() {
        List<Licenciatura> licenciatura = licenciaturaRepository.findAll();
        List<LicenciaturaDTO> licenciaturaDTO = new LinkedList<>();
        for (Licenciatura lic : licenciatura) {
            licenciaturaDTO.add(licenciaturaMapper.toLicenciaturaDTO(lic));
        }
        return licenciaturaDTO;
    }

    @Override
    public LicenciaturaDTO save(LicenciaturaDTO licenciaturaDTO) {
        Licenciatura licenciatura = licenciaturaMapper.toLicenciatura(licenciaturaDTO);
        licenciatura = licenciaturaRepository.save(licenciatura);
        LicenciaturaDTO licenciaturaDTODTO = licenciaturaMapper.toLicenciaturaDTO(licenciatura);

        return licenciaturaDTODTO;
    }
}
