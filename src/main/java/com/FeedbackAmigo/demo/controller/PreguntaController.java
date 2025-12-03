package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.PreguntaDTO;
import com.FeedbackAmigo.demo.service.PreguntaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PreguntaController {
    private final PreguntaService preguntaService;

    public PreguntaController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    @GetMapping("/preguntas")
    public List<PreguntaDTO> getPreguntas(){
        return preguntaService.getPreguntas();
    }

    @GetMapping("/preguntas/{id}")
    public PreguntaDTO getPregunta(@PathVariable Long id){
        return preguntaService.getPreguntaById(id);
    }

    @PostMapping("/preguntas")
    public PreguntaDTO create(@RequestBody PreguntaDTO preguntaDTO){
        return preguntaService.save(preguntaDTO);
    }

    @PutMapping("/preguntas/{id}")
    public PreguntaDTO update(@PathVariable Long id, @RequestBody PreguntaDTO preguntaDTO){
        return preguntaService.update(id, preguntaDTO);
    }

    @DeleteMapping("/preguntas/{id}")
    public String delete(@PathVariable Long id){
        preguntaService.delete(id);
        return "Pregunta eliminada con exito";
    }
}
