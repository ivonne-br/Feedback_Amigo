package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.UEADto;
import com.FeedbackAmigo.demo.entity.UEAEntity;
import com.FeedbackAmigo.demo.mapper.UEAMapper;
import com.FeedbackAmigo.demo.repository.UEARepository;
import com.FeedbackAmigo.demo.service.UEAService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UEAServiceImpl implements UEAService {

    private final UEAMapper ueaMapper;
    private final UEARepository ueaRepository;

    public UEAServiceImpl(UEAMapper ueaMapper, UEARepository ueaRepository) {
        this.ueaMapper = ueaMapper;
        this.ueaRepository = ueaRepository;
    }

    @Override
    public List<UEADto> getAll() {
        return ueaRepository.findAll()
                .stream()
                .map(ueaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UEADto getById(Long id) {
        UEAEntity entity = ueaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UEA no encontrada"));
        return ueaMapper.toDTO(entity);
    }


    @Override
    public List<UEAEntity> buscarNombreParcial(String nombre){
        return ueaRepository.findByNombreContainingIgnoreCase(nombre);
    }


    @Override
    public Optional<UEAEntity> buscarPorNombreExacto(String nombre){
        return ueaRepository.findByNombreIgnoreCase(nombre);
    }



    @Override
    public UEADto create(UEADto dto) {
        UEAEntity entity = ueaMapper.toEntity(dto);
        UEAEntity saved = ueaRepository.save(entity);
        return ueaMapper.toDTO(saved);
    }

    @Override
    public UEADto update(Long id, UEADto dto) {
        UEAEntity entity = ueaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UEA no encontrada"));

        entity.setNombre(dto.getNombre());
        UEAEntity updated = ueaRepository.save(entity);
        return ueaMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        ueaRepository.deleteById(id);
    }
}
