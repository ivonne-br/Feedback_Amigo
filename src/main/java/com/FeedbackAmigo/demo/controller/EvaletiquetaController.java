package com.FeedbackAmigo.demo.controller;

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


    // CREATE
    @PostMapping
    public ResponseEntity<EvaletiquetaDto> create(@RequestBody EvaletiquetaDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<EvaletiquetaDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EvaletiquetaDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<EvaletiquetaDto> update(@PathVariable Long id, @RequestBody EvaletiquetaDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.save(dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // EXTRA ENDPOINTS
    @GetMapping("/alumno/{idAlumnoEvaluado}")
    public ResponseEntity<List<EvaletiquetaDto>> getByAlumnoEvaluado(@PathVariable Long idAlumnoEvaluado) {
        return ResponseEntity.ok(service.findByAlumnoEvaluado(idAlumnoEvaluado));
    }

    @GetMapping("/evaluador/{idAlumnoEvaluador}")
    public ResponseEntity<List<EvaletiquetaDto>> getByAlumnoEvaluador(@PathVariable Long idAlumnoEvaluador) {
        return ResponseEntity.ok(service.findByAlumnoEvaluador(idAlumnoEvaluador));
    }

    @GetMapping("/uea/{idUea}")
    public ResponseEntity<List<EvaletiquetaDto>> getByUea(@PathVariable Long idUea) {
        return ResponseEntity.ok(service.findByUea(idUea));
    }

    @GetMapping("/evaluacion/{idEvaluacion}")
    public ResponseEntity<List<EvaletiquetaDto>> getByEvaluacion(@PathVariable Long idEvaluacion) {
        return ResponseEntity.ok(service.findByEvaluacion(idEvaluacion));
    }
}
