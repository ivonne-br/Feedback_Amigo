package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.UEADto;
import com.FeedbackAmigo.demo.service.UEAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ueas")
public class UEAController {

    @Autowired
    private UEAService ueaService;

    @GetMapping
    public List<UEADto> getAll() {
        return ueaService.getAll();
    }

    @GetMapping("/{id}")
    public UEADto getById(@PathVariable Long id) {
        return ueaService.getById(id);
    }

    @PostMapping
    public UEADto create(@RequestBody UEADto dto) {
        return ueaService.create(dto);
    }

    @PutMapping("/{id}")
    public UEADto update(@PathVariable Long id, @RequestBody UEADto dto) {
        return ueaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ueaService.delete(id);
    }
    @GetMapping("/ping")
    public String ping() {
        return "UEAController activo";
    }
}


