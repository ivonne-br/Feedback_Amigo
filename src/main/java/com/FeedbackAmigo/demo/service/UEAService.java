package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.UEADto;
import com.FeedbackAmigo.demo.entity.UEAEntity;

import java.util.List;
import java.util.Optional;

public interface UEAService {
    List<UEADto> getAll();
    UEADto getById(Long id);

    List<UEAEntity> buscarNombreParcial(String nombre);
    Optional<UEAEntity> buscarPorNombreExacto(String nombre);
    UEADto create(UEADto dto);
    UEADto update(Long id, UEADto dto);
    void delete(Long id);
}
