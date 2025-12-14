package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.EvaluacionDTO;
import com.FeedbackAmigo.demo.dto.EvaluacionPatchDTO;
import com.FeedbackAmigo.demo.entity.Alumno;
import com.FeedbackAmigo.demo.entity.Evaluacion;
import com.FeedbackAmigo.demo.entity.UEAEntity;
import com.FeedbackAmigo.demo.mapper.EvaluacionMapper;
import com.FeedbackAmigo.demo.repository.AlumnoRepository;
import com.FeedbackAmigo.demo.repository.EvaluacionRepository;
import com.FeedbackAmigo.demo.repository.UEARepository;
import com.FeedbackAmigo.demo.service.EvaluacionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

@Service
public class EvaluacionServiceImpl  implements EvaluacionService {
    private final EvaluacionRepository repository;
   private final EvaluacionMapper evaluacionMapper;
    private final AlumnoRepository alumnoRepository;
    private final UEARepository ueaRepository;


    public EvaluacionServiceImpl(EvaluacionRepository repository, EvaluacionMapper evaluacionMapper, AlumnoRepository alumnoRepository, UEARepository ueaRepository) {
        this.repository = repository;
        this.evaluacionMapper = evaluacionMapper;
        this.alumnoRepository = alumnoRepository;
        this.ueaRepository = ueaRepository;
    }

    @Override
    public List<EvaluacionDTO> getEvaluaciones(){
       List<Evaluacion> evaluaciones = repository.findAll();
       List<EvaluacionDTO> evaluacionDTOS = new LinkedList<>();
       for (Evaluacion evaluacion : evaluaciones) {
           evaluacionDTOS.add(evaluacionMapper.toEvaluacionDTO(evaluacion));
       }
       return evaluacionDTOS;
   }

   @Override
    public EvaluacionDTO getEvaluacionById(Long id){
       Evaluacion evaluacion = repository.findById(id).orElseThrow(() -> new RuntimeException("Evaluacion no encontrada"));
       return evaluacionMapper.toEvaluacionDTO(evaluacion);

   }

   @Override
   public EvaluacionDTO save(EvaluacionDTO dto) {

       Alumno evaluador = alumnoRepository.findById(dto.getIdAlumnoEvaluador())
               .orElseThrow(() -> new RuntimeException("Alumno evaluador no encontrado"));

       Alumno evaluado = alumnoRepository.findById(dto.getIdAlumnoEvaluado())
               .orElseThrow(() -> new RuntimeException("Alumno evaluado no encontrado"));

       UEAEntity uea = ueaRepository.findById(dto.getIdUea())
               .orElseThrow(() -> new RuntimeException("UEA no encontrada"));

       Evaluacion evaluacion = evaluacionMapper.toEvaluacion(dto, evaluador, evaluado, uea);

       evaluacion = repository.save(evaluacion);

       return evaluacionMapper.toEvaluacionDTO(evaluacion);
   }


    @Override
    public EvaluacionDTO patchEvaluacion(Long id, EvaluacionPatchDTO patchDTO) {

        Evaluacion evaluacion = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Evaluación con ID " + id + " no encontrada"
                ));

        // 🔹 Actualización parcial
        if (patchDTO.getAnonimo() != null) {
            evaluacion.setAnonimo(patchDTO.getAnonimo());
        }

        if (patchDTO.getComentarios() != null) {
            evaluacion.setComentarios(patchDTO.getComentarios());
        }


        // Guardar cambios
        Evaluacion actualizada = repository.save(evaluacion);

        return evaluacionMapper.toEvaluacionDTO(actualizada);
    }



    @Override
    public EvaluacionDTO update(Long id, EvaluacionDTO dto) {

        Evaluacion evaluacion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));

        Alumno evaluador = alumnoRepository.findById(dto.getIdAlumnoEvaluador())
                .orElseThrow(() -> new RuntimeException("Alumno evaluador no encontrado"));

        Alumno evaluado = alumnoRepository.findById(dto.getIdAlumnoEvaluado())
                .orElseThrow(() -> new RuntimeException("Alumno evaluado no encontrado"));

        UEAEntity uea = ueaRepository.findById(dto.getIdUea())
                .orElseThrow(() -> new RuntimeException("UEA no encontrada"));

        evaluacion.setAlumnoEvaluador(evaluador);
        evaluacion.setAlumnoEvaluado(evaluado);
        evaluacion.setUea(uea);

        evaluacion.setAnonimo(dto.isAnonimo());
        evaluacion.setFechaEvaluacion(dto.getFechaEvaluacion());
        evaluacion.setComentarios(dto.getComentarios());
        evaluacion.setCalificacion(dto.getCalificacion());

        evaluacion = repository.save(evaluacion);

        return evaluacionMapper.toEvaluacionDTO(evaluacion);
    }


    @Override
    public void delete(Long id){
       if(!repository.existsById(id)){
           throw new RuntimeException("Evaluacion no encontrada");
       }
       repository.deleteById(id);
   }


}
