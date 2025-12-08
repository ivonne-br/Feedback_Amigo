package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;
import com.FeedbackAmigo.demo.service.RespuestaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/respuestas")
public class RespuestaController {
    private final RespuestaService respuestaService;

    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @GetMapping
    public List<RespuestaDTO> getRespuestas() {
        return respuestaService.getRespuestas();
    }

    @GetMapping("/{id}")
    public RespuestaDTO getRespuestaById(@PathVariable Long id) {
        return respuestaService.getRespuestaById(id);
    }

    @PostMapping
    public RespuestaDTO create(@RequestBody RespuestaDTO respuestaDTO) {
        return respuestaService.save(respuestaDTO);
    }
    @PutMapping("/{id}")
    public RespuestaDTO update(@PathVariable Long id, @RequestBody RespuestaDTO respuestaDTO) {
        return respuestaService.update(id, respuestaDTO);
    }

    @DeleteMapping("/{id}")
    public String  delete(@PathVariable Long id) {
        respuestaService.delete(id);
        return "Respuesta eliminada con exito";
    }
}
