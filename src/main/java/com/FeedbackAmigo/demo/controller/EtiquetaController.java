package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.EtiquetaDTO;
import com.FeedbackAmigo.demo.repository.EtiquetaRepository;
import com.FeedbackAmigo.demo.service.EtiquetaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/etiquetas")
public class EtiquetaController {

    private final EtiquetaService etiquetaService;

    public EtiquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }

    @GetMapping
    public List<EtiquetaDTO> getAll() {
        return etiquetaService.getEtiquetas();
    }

    @GetMapping("/{id}")
    public EtiquetaDTO get(@PathVariable Long id) {
        return etiquetaService.getEtiquetaById(id);
    }

    @PostMapping
    public EtiquetaDTO create(@RequestBody EtiquetaDTO etiquetaDTO) {
        return etiquetaService.save(etiquetaDTO);
    }

    @PutMapping("/{id}")
    public EtiquetaDTO update(@PathVariable Long id, @RequestBody EtiquetaDTO etiquetaDTO) {
        return etiquetaService.update(id, etiquetaDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        etiquetaService.delete(id);
        return "Etiqueta eliminada con exito";
    }
}
