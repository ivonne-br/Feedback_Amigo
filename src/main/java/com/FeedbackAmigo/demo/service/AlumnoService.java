package com.FeedbackAmigo.demo.service;

import com.FeedbackAmigo.demo.dto.AlumnoDTO;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<AlumnoDTO> findAll();

    Optional<AlumnoDTO> findById(Long id);

    List<AlumnoDTO> buscarPorNombreParcial(String nombre);

    List<AlumnoDTO >buscarPorNombreExacto(String nombre, String apellidoP, String apellidoM);

    AlumnoDTO save(AlumnoDTO dto);

    Optional<AlumnoDTO> findById(long id);

    void update(long id, AlumnoDTO dto);

    void deleteById(Long id);

    void deleteAll();
}