package com.FeedbackAmigo.demo.repository;

import com.FeedbackAmigo.demo.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    List<Alumno> findByNombreContainingIgnoreCase(String nombre);
    List<Alumno> findByNombreIgnoreCaseAndApellidoPIgnoreCaseAndApellidoMIgnoreCase(String nombre, String apellidoP, String apellidoM );
}
