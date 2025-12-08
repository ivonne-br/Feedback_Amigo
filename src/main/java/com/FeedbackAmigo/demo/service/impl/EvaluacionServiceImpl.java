package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.EvaluacionDTO;
import com.FeedbackAmigo.demo.entity.Alumno;
import com.FeedbackAmigo.demo.entity.Evaluacion;
import com.FeedbackAmigo.demo.entity.UEA;
import com.FeedbackAmigo.demo.mapper.EvaluacionMapper;
import com.FeedbackAmigo.demo.repository.AlumnoRepository;
import com.FeedbackAmigo.demo.repository.EvaluacionRepository;
import com.FeedbackAmigo.demo.repository.UEARepository;
import com.FeedbackAmigo.demo.service.EvaluacionService;
import org.springframework.stereotype.Service;

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

       UEA uea = ueaRepository.findById(dto.getIdUea())
               .orElseThrow(() -> new RuntimeException("UEA no encontrada"));

       Evaluacion evaluacion = evaluacionMapper.toEvaluacion(dto, evaluador, evaluado, uea);

       evaluacion = repository.save(evaluacion);

       return evaluacionMapper.toEvaluacionDTO(evaluacion);
   }


    @Override
    public EvaluacionDTO update(Long id, EvaluacionDTO dto) {

        Evaluacion evaluacion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));

        Alumno evaluador = alumnoRepository.findById(dto.getIdAlumnoEvaluador())
                .orElseThrow(() -> new RuntimeException("Alumno evaluador no encontrado"));

        Alumno evaluado = alumnoRepository.findById(dto.getIdAlumnoEvaluado())
                .orElseThrow(() -> new RuntimeException("Alumno evaluado no encontrado"));

        UEA uea = ueaRepository.findById(dto.getIdUea())
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
