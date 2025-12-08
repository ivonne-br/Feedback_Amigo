package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;
import com.FeedbackAmigo.demo.entity.RespuestaId;
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


    @GetMapping("/{evaluador}/{evaluado}/{uea}/{pregunta}")
    public RespuestaDTO getRespuestaById(@PathVariable long evaluador, @PathVariable long evaluado, @PathVariable long uea, @PathVariable long pregunta) {
        return respuestaService.getRespuestaById(new RespuestaId(evaluador, evaluado, uea, pregunta));
    }

    @PostMapping
    public RespuestaDTO create(@RequestBody RespuestaDTO respuestaDTO) {
        return respuestaService.save(respuestaDTO);
    }

    @PutMapping("/{evaluador}/{evaluado}/{uea}/{pregunta}")
    public RespuestaDTO update(@PathVariable long evaluador, @PathVariable long evaluado, @PathVariable long uea, @PathVariable long pregunta, @RequestBody RespuestaDTO respuestaDTO) {
        return respuestaService.update(new RespuestaId(evaluador, evaluado, uea, pregunta), respuestaDTO);

    }

    @DeleteMapping("/{evaluador}/{evaluado}/{uea}/{pregunta}")
    public String  delete(@PathVariable long evaluador, @PathVariable long evaluado, @PathVariable long uea, @PathVariable long pregunta) {
        respuestaService.delete(new RespuestaId(evaluador, evaluado, uea, pregunta));
        return "Respuesta eliminada con exito";
    }
}
