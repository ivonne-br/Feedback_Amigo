/*package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;
import com.FeedbackAmigo.demo.entity.Evaluacion;
import com.FeedbackAmigo.demo.entity.Pregunta;
import com.FeedbackAmigo.demo.entity.Respuesta;
import com.FeedbackAmigo.demo.mapper.RespuestaMapper;
import com.FeedbackAmigo.demo.repository.EvaluacionRepository;
import com.FeedbackAmigo.demo.repository.PreguntaRepository;
import com.FeedbackAmigo.demo.repository.RespuestaRepository;
import com.FeedbackAmigo.demo.service.RespuestaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class RespuestaServiceImpl implements RespuestaService {
    private final RespuestaMapper respuestaMapper;
    private final RespuestaRepository respuestaRepository;
    private final PreguntaRepository preguntaRepository;
    private final EvaluacionRepository evaluacionRepository;

    public RespuestaServiceImpl(RespuestaMapper respuestaMapper, RespuestaRepository respuestaRepository, PreguntaRepository preguntaRepository, EvaluacionRepository evaluacionRepository) {

        this.respuestaMapper = respuestaMapper;
        this.respuestaRepository = respuestaRepository;
        this.preguntaRepository = preguntaRepository;
        this.evaluacionRepository = evaluacionRepository;
    }

    @Override
    public List<RespuestaDTO> getRespuestas(){
        List<Respuesta> respuestas = respuestaRepository.findAll();
        List<RespuestaDTO> respuestasDTO = new LinkedList<>();
        for (Respuesta respuesta : respuestas) {
            respuestasDTO.add(respuestaMapper.toRespuestaDTO(respuesta));
        }
        return respuestasDTO;
    }

    @Override
    public RespuestaDTO getRespuestaById(Long id){
        Respuesta respuesta = respuestaRepository.findById(id).orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));
        return respuestaMapper.toRespuestaDTO(respuesta);
    }

    @Override
    public RespuestaDTO save(Long id, RespuestaDTO respuestaDTO){
        Pregunta pregunta = preguntaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
       Evaluacion evaluacion= evaluacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));

       Respuesta respuesta = respuestaMapper.toRespuesta(respuestaDTO);
       respuesta.setPregunta(pregunta);
       respuesta.setEvaluacion(evaluacion);
       respuestaRepository.save(respuesta);
       return respuestaMapper.toRespuestaDTO(respuesta);
    }

    @Override
    public  RespuestaDTO update(Long id, RespuestaDTO respuestaDTO){
        Respuesta respuesta = respuestaRepository.findById(id).orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));

        respuesta.setValor(respuestaDTO.getValor());

        respuesta = respuestaRepository.save(respuesta);
        return respuestaMapper.toRespuestaDTO(respuesta);
    }

    @Override
    public void delete(Long id){
        if(!respuestaRepository.existsById(id)){
            throw new RuntimeException("Respuesta no encontrada");
        }
        respuestaRepository.deleteById(id);

    }
}
*/

package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.RespuestaDTO;
import com.FeedbackAmigo.demo.entity.Evaluacion;
import com.FeedbackAmigo.demo.entity.Pregunta;
import com.FeedbackAmigo.demo.entity.Respuesta;
import com.FeedbackAmigo.demo.mapper.RespuestaMapper;
import com.FeedbackAmigo.demo.repository.EvaluacionRepository;
import com.FeedbackAmigo.demo.repository.PreguntaRepository;
import com.FeedbackAmigo.demo.repository.RespuestaRepository;
import com.FeedbackAmigo.demo.service.RespuestaService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
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
}
