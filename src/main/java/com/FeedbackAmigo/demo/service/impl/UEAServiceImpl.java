package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.UEADto;
import com.FeedbackAmigo.demo.entity.UEAEntity;
import com.FeedbackAmigo.demo.mapper.UEAMapper;
import com.FeedbackAmigo.demo.repository.UEARepository;
import com.FeedbackAmigo.demo.service.UEAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UEAServiceImpl implements UEAService {

    @Autowired
    private UEARepository ueaRepository;

    @Autowired
    private UEAMapper ueaMapper;

    @Override
    public List<UEADto> getAll() {
        return ueaRepository.findAll()
                .stream()
                .map(ueaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UEADto getById(Long id) {
        return ueaMapper.toDto(ueaRepository.findById(id).orElseThrow());
    }

    @Override
    public UEADto create(UEADto dto) {
        UEAEntity entity = ueaMapper.toEntity(dto);
        return ueaMapper.toDto(ueaRepository.save(entity));
    }
    @Override
    public UEADto update(Long id, UEADto dto) {
        UEAEntity existing = ueaRepository.findById(id).orElseThrow();
        existing.setNombre(dto.getNombre());
        return ueaMapper.toDto(ueaRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        ueaRepository.deleteById(id);
    }
}


