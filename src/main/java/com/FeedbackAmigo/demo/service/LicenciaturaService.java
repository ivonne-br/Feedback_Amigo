package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.LicenciaturaDTO;

import java.util.List;
import java.util.Optional;

public interface LicenciaturaService {
    List<LicenciaturaDTO> findAll();
    LicenciaturaDTO save(LicenciaturaDTO licenciaturaDTO);

    void deleteById(long id);

    void update(long id, LicenciaturaDTO licenciaturaDTO);

    Optional<LicenciaturaDTO> findById(long id);

    boolean existsById(long id);
}
