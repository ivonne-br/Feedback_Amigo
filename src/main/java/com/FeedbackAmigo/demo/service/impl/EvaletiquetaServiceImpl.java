package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.EvaletiquetaDto;
import com.FeedbackAmigo.demo.entity.Evaletiqueta;
import com.FeedbackAmigo.demo.mapper.EvaletiquetaMapper;
import com.FeedbackAmigo.demo.repository.EvaletiquetaRepository;
import com.FeedbackAmigo.demo.service.EvaletiquetaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaletiquetaServiceImpl implements EvaletiquetaService {

    private final EvaletiquetaRepository repository;
    private final EvaletiquetaMapper mapper;

    public EvaletiquetaServiceImpl(EvaletiquetaRepository repository, EvaletiquetaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EvaletiquetaDto save(EvaletiquetaDto dto) {
        Evaletiqueta entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<EvaletiquetaDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EvaletiquetaDto findById(Long id) {
        return  repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<EvaletiquetaDto> findByAlumnoEvaluado(Long idAlumnoEvaluado) {
        return repository.findByIdAlumnoEvaluado(idAlumnoEvaluado).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EvaletiquetaDto> findByAlumnoEvaluador(Long idAlumnoEvaluador) {
        return repository.findByIdAlumnoEvaluador(idAlumnoEvaluador).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EvaletiquetaDto> findByUea(Long idUea) {
        return repository.findByIdUea_Id(idUea).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EvaletiquetaDto> findByEvaluacion(Long idEvaluacion) {
        return repository.findByIdEvaluacion(idEvaluacion).stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
