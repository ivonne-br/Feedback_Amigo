package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.UEADto;
import com.FeedbackAmigo.demo.entity.UEAEntity;
import com.FeedbackAmigo.demo.service.UEAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/parcial")
    public ResponseEntity<List<UEAEntity>> buscarPorParcial(
            @RequestParam String nombre) {

        List<UEAEntity> resultado = ueaService.buscarNombreParcial(nombre);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/exacto")
    public ResponseEntity<Object> buscarPorExacto(@RequestParam String nombre) {
        Optional<UEAEntity> resultado = ueaService.buscarPorNombreExacto(nombre);

        if (resultado.isPresent()) {
            // si usas un DTO, conviértelo: UEADto dto = ueaMapper.toDTO(resultado.get());
            return ResponseEntity.ok(resultado.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "No se encontró ninguna UEA con ese nombre exacto"));
        }
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
}

