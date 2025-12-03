/*package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.EvaletiquetaDto;
import com.FeedbackAmigo.demo.service.EvaletiquetaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaletiquetas")
public class EvaletiquetaController {

    private final EvaletiquetaService service;

    public EvaletiquetaController(EvaletiquetaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EvaletiquetaDto> create(@RequestBody EvaletiquetaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/evaluacion/{idEvaluacion}")
    public ResponseEntity<List<EvaletiquetaDto>> getByEvaluacion(@PathVariable Long idEvaluacion) {
        return ResponseEntity.ok(service.findByEvaluacion(idEvaluacion));
    }
}
*/