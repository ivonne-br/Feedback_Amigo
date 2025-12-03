package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.EvaluacionDTO;
import com.FeedbackAmigo.demo.entity.Evaluacion;
import com.FeedbackAmigo.demo.service.EvaluacionService;
import com.FeedbackAmigo.demo.service.PreguntaService;
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

    @PostMapping("/evaluaciones")
    public EvaluacionDTO createEvaluacion(@RequestBody EvaluacionDTO evaluacionDTO){
        return evaluacionService.save(evaluacionDTO);
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
