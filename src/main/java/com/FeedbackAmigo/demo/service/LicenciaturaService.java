package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.LicenciaturaDTO;

import java.util.List;

public interface LicenciaturaService {
    List<LicenciaturaDTO> findAll();
    LicenciaturaDTO save(LicenciaturaDTO licenciaturaDTO);
}
