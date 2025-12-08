package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.PreguntaDTO;
import com.FeedbackAmigo.demo.entity.Pregunta;
import com.FeedbackAmigo.demo.mapper.PreguntaMapper;
import com.FeedbackAmigo.demo.repository.PreguntaRepository;
import com.FeedbackAmigo.demo.service.PreguntaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class PreguntaServiceImpl implements PreguntaService {
    private final PreguntaMapper preguntaMapper;
    private final PreguntaRepository preguntaRepository;

    public PreguntaServiceImpl(PreguntaMapper preguntaMapper, PreguntaRepository preguntaRepository) {
        this.preguntaMapper = preguntaMapper;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public List<PreguntaDTO> getPreguntas(){
        List<Pregunta> preguntas = preguntaRepository.findAll();
        List<PreguntaDTO> preguntasDTO = new LinkedList<>();
        for (Pregunta pregunta : preguntas) {
            preguntasDTO.add(preguntaMapper.toPreguntaDTO(pregunta));
        }
        return preguntasDTO;
    }

    @Override
    public PreguntaDTO getPreguntaById(Long id){
        Pregunta pregunta = preguntaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
        return preguntaMapper.toPreguntaDTO(pregunta);
    }

    @Override
    public PreguntaDTO save(PreguntaDTO preguntaDTO){
        Pregunta pregunta = preguntaMapper.toPregunta(preguntaDTO);
        pregunta = preguntaRepository.save(pregunta);
        return preguntaMapper.toPreguntaDTO(pregunta);
    }

    @Override
    public PreguntaDTO update(Long id, PreguntaDTO preguntaDTO ){
        Pregunta pregunta = preguntaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));

        pregunta.setTextoPregunta(preguntaDTO.getTextoPregunta());
        pregunta.setCategoria(preguntaDTO.getCategoria());
        pregunta.setEstado(preguntaDTO.getEstado());
        pregunta = preguntaRepository.save(pregunta);
        return preguntaMapper.toPreguntaDTO(pregunta);
    }

    @Override
    public void delete(Long id){
        preguntaRepository.deleteById(id);
    }
}
