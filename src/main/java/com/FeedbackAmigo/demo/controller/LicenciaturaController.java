package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.LicenciaturaDTO;
import com.FeedbackAmigo.demo.service.LicenciaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/l1")
public class LicenciaturaController {
    private final LicenciaturaService licenciaturaService;

    public LicenciaturaController(LicenciaturaService licenciaturaService) {
        this.licenciaturaService = licenciaturaService;
    }

    @GetMapping("/licenciatura")
    public List<LicenciaturaDTO> findAll() {
        return licenciaturaService.findAll();
    }

    @PostMapping("/licenciatura")
    public LicenciaturaDTO create(@RequestBody LicenciaturaDTO licenciaturaDTO) {
        return licenciaturaService.save(licenciaturaDTO);
    }
}
