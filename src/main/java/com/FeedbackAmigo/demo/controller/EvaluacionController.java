package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.EvaluacionDTO;
import com.FeedbackAmigo.demo.dto.EvaluacionPatchDTO;
import com.FeedbackAmigo.demo.entity.Evaluacion;
import com.FeedbackAmigo.demo.service.EvaluacionService;
import com.FeedbackAmigo.demo.service.PreguntaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1")
public class EvaluacionController {
    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;

    }

    @GetMapping("/evaluaciones")
    public
    List<EvaluacionDTO> getEvaluaciones(){
        return evaluacionService.getEvaluaciones();
    }

    @GetMapping("/evaluaciones/{id}")
    public EvaluacionDTO getEvaluacion(@PathVariable Long id){
        return evaluacionService.getEvaluacionById(id);
    }

    @GetMapping("/evaluaciones/evaluador/{idAlumno}")
    public ResponseEntity<List<EvaluacionDTO>> getEvaluacionesByEvaluador(
            @PathVariable Long idAlumno
    ) {
        return ResponseEntity.ok(
                evaluacionService.getEvaluacionesByEvaluador(idAlumno)
        );
    }

    @PostMapping("/evaluaciones")
    public EvaluacionDTO createEvaluacion(@RequestBody EvaluacionDTO evaluacionDTO){
        return evaluacionService.save(evaluacionDTO);
    }

    @PatchMapping("/evaluaciones/{id}")
    public ResponseEntity<EvaluacionDTO> patchEvaluacion(
            @PathVariable Long id,
            @RequestBody EvaluacionPatchDTO patchDTO) {

        EvaluacionDTO evaluacionActualizada =
                evaluacionService.patchEvaluacion(id, patchDTO);

        return ResponseEntity.ok(evaluacionActualizada);
    }


    @PutMapping("/evaluaciones/{id}")
    public EvaluacionDTO updateEvaluacion(@PathVariable Long id, @RequestBody EvaluacionDTO evaluacionDTO){
        return evaluacionService.update(id, evaluacionDTO);
    }

    @DeleteMapping("/evaluaciones/{id}")
    public String delete(@PathVariable Long id){
        evaluacionService.delete(id);
        return "Evaluación eliminada con exito";
    }


}
