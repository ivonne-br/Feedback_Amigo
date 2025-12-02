package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.LicenciaturaDTO;
import com.FeedbackAmigo.demo.entity.Licenciatura;
import com.FeedbackAmigo.demo.service.LicenciaturaService;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @DeleteMapping("/licenciatura/{id}")
    public void deleteById(@PathVariable long id) {
        licenciaturaService.deleteById(id);
    }

    @PutMapping("/licenciatura/{id}")
    public void update(@PathVariable long id, @RequestBody LicenciaturaDTO licenciaturaDTO) {
        licenciaturaService.update(id, licenciaturaDTO);
    }

    @GetMapping("/licenciatura/{id}")
    public LicenciaturaDTO findById(@PathVariable Long id) {
        return licenciaturaService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Licenciatura con ID " + id + " no encontrada"
                ));
    }}
