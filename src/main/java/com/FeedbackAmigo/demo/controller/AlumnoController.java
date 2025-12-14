package com.FeedbackAmigo.demo.controller;

import com.FeedbackAmigo.demo.dto.AlumnoDTO;
import com.FeedbackAmigo.demo.service.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/l1")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/alumno")
    public List<AlumnoDTO> findAll() {
        return alumnoService.findAll();
    }

    @GetMapping("/alumno/{id}")
    public AlumnoDTO findById(@PathVariable Long id) {
        return alumnoService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Alumno con ID " + id + " no encontrado"));
    }

    @GetMapping("/alumno/parcial")
    public ResponseEntity<List<AlumnoDTO>> buscarParcial(@RequestParam String nombre) {
        return ResponseEntity.ok(alumnoService.buscarPorNombreParcial(nombre));
    }

    @GetMapping("/alumno/exacto")
    public ResponseEntity<List<AlumnoDTO>> buscarExacto(@RequestParam String nombre, @RequestParam String apellidoP, @RequestParam String apellidoM) {
        return ResponseEntity.ok(alumnoService.buscarPorNombreExacto(nombre, apellidoP, apellidoM));
    }

    @PostMapping("/alumno")
    public AlumnoDTO create(@RequestBody AlumnoDTO dto) {
        return alumnoService.save(dto);
    }

    @PutMapping("/alumno/{id}")
    public void update(@PathVariable Long id, @RequestBody AlumnoDTO dto) {
        alumnoService.update(id, dto);}

    @DeleteMapping("/alumno/{id}")
    public void deleteById(@PathVariable Long id) {
        alumnoService.deleteById(id);
    }

    @DeleteMapping("/alumno")
    public void deleteAll() {alumnoService.deleteAll();}
}