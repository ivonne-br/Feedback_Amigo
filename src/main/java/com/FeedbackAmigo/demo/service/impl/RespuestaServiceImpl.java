
package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;
import com.FeedbackAmigo.demo.entity.Evaluacion;
import com.FeedbackAmigo.demo.entity.Pregunta;
import com.FeedbackAmigo.demo.entity.Respuesta;
import com.FeedbackAmigo.demo.entity.RespuestaId;
import com.FeedbackAmigo.demo.mapper.RespuestaMapper;
import com.FeedbackAmigo.demo.repository.*;
import com.FeedbackAmigo.demo.service.RespuestaService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    private final RespuestaMapper mapper;
    private final RespuestaRepository respuestaRepository;
    private final EvaluacionRepository evaluacionRepository;
    private final AlumnoRepository alumnoRepository;
    private final UEARepository ueaRepository;
    private final PreguntaRepository preguntaRepository;

    public RespuestaServiceImpl(
            RespuestaMapper mapper,
            RespuestaRepository respuestaRepository,
            EvaluacionRepository evaluacionRepository,
            AlumnoRepository alumnoRepository,
            UEARepository ueaRepository,
            PreguntaRepository preguntaRepository
    ) {
        this.mapper = mapper;
        this.respuestaRepository = respuestaRepository;
        this.evaluacionRepository = evaluacionRepository;
        this.alumnoRepository = alumnoRepository;
        this.ueaRepository = ueaRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public List<RespuestaDTO> getRespuestas() {
        List<RespuestaDTO> lista = new LinkedList<>();
        for (Respuesta r : respuestaRepository.findAll()) {
            lista.add(mapper.toRespuestaDTO(r));
        }
        return lista;
    }

    @Override
    public RespuestaDTO getRespuestaById(RespuestaId id) {
        Respuesta r = respuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));
        return mapper.toRespuestaDTO(r);
    }

    @Override
    public RespuestaDTO save(RespuestaDTO dto) {

        Respuesta respuesta = mapper.toRespuesta(dto);

        // cargar relaciones

        respuesta.setEvaluacion(
               evaluacionRepository.findById(dto.getIdEvaluacion())
                        .orElseThrow(() -> new RuntimeException("Evaluación no encontrada"))
        );
        respuesta.setAlumnoEvaluador(
                alumnoRepository.findById(dto.getIdAlumnoEvaluador())
                        .orElseThrow(() -> new RuntimeException("Alumno evaluador no encontrado"))
        );

        respuesta.setAlumnoEvaluado(
                alumnoRepository.findById(dto.getIdAlumnoEvaluado())
                        .orElseThrow(() -> new RuntimeException("Alumno evaluado no encontrado"))
        );

        respuesta.setUea(
                ueaRepository.findById(dto.getIdUea())
                        .orElseThrow(() -> new RuntimeException("UEA no encontrada"))
        );

        respuesta.setPregunta(
                preguntaRepository.findById(dto.getIdPregunta())
                        .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"))
        );

        respuesta = respuestaRepository.save(respuesta);

        return mapper.toRespuestaDTO(respuesta);
    }

    @Override
    public RespuestaDTO update(RespuestaId id, RespuestaDTO dto) {

        Respuesta respuesta = respuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));

        respuesta.setValor(dto.getValor());

        respuesta = respuestaRepository.save(respuesta);

        return mapper.toRespuestaDTO(respuesta);
    }

    @Override
    public void delete(RespuestaId id) {
        respuestaRepository.deleteById(id);
    }
}

/* @Service
public class RespuestaServiceImpl implements RespuestaService {

    private final RespuestaMapper mapper;
    private final RespuestaRepository respuestaRepository;
    private final PreguntaRepository preguntaRepository;
    private final EvaluacionRepository evaluacionRepository;

    public RespuestaServiceImpl(RespuestaMapper mapper, RespuestaRepository respuestaRepository,
                                PreguntaRepository preguntaRepository, EvaluacionRepository evaluacionRepository) {
        this.mapper = mapper;
        this.respuestaRepository = respuestaRepository;
        this.preguntaRepository = preguntaRepository;
        this.evaluacionRepository = evaluacionRepository;
    }

    @Override
    public List<RespuestaDTO> getRespuestas() {
        List<Respuesta> respuestas = respuestaRepository.findAll();
        List<RespuestaDTO> dtos = new LinkedList<>();
        for (Respuesta r : respuestas) {
            dtos.add(mapper.toRespuestaDTO(r));
        }
        return dtos;
    }

    @Override
    public RespuestaDTO getRespuestaById(Long id) {
        Respuesta r = respuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));
        return mapper.toRespuestaDTO(r);
    }

    @Override
    public RespuestaDTO save(RespuestaDTO dto) {
        Pregunta pregunta = preguntaRepository.findById(dto.getIdPregunta())
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
        Evaluacion evaluacion = evaluacionRepository.findById(dto.getIdEvaluacion())
                .orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));

        Respuesta respuesta = new Respuesta();
        respuesta.setValor(dto.getValor());
        respuesta.setPregunta(pregunta);
        respuesta.setEvaluacion(evaluacion);

        respuesta = respuestaRepository.save(respuesta);
        return mapper.toRespuestaDTO(respuesta);
    }

    @Override
    public RespuestaDTO update(Long id, RespuestaDTO dto) {
        Respuesta respuesta = respuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));

        respuesta.setValor(dto.getValor());

        // Actualizar relaciones si se desea
        if (dto.getIdPregunta() != null) {
            Pregunta pregunta = preguntaRepository.findById(dto.getIdPregunta())
                    .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
            respuesta.setPregunta(pregunta);
        }

        if (dto.getIdEvaluacion() != null) {
            Evaluacion evaluacion = evaluacionRepository.findById(dto.getIdEvaluacion())
                    .orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));
            respuesta.setEvaluacion(evaluacion);
        }

        respuesta = respuestaRepository.save(respuesta);
        return mapper.toRespuestaDTO(respuesta);
    }

    @Override
    public void delete(Long id) {
        if (!respuestaRepository.existsById(id)) {
            throw new RuntimeException("Respuesta no encontrada");
        }
        respuestaRepository.deleteById(id);
    }

} */

