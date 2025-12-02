package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.UEADto;

import java.util.List;

public interface UEAService {
    List<UEADto> getAll();
    UEADto getById(Long id);
    UEADto create(UEADto dto);
    UEADto update(Long id, UEADto dto);
    void delete(Long id);
}
