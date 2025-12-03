package com.FeedbackAmigo.demo.service.impl;


import com.FeedbackAmigo.demo.dto.EvaletiquetaDto;
import com.FeedbackAmigo.demo.entity.Evaletiqueta;
import com.FeedbackAmigo.demo.mapper.EvaletiquetaMapper;
import com.FeedbackAmigo.demo.repository.EvaletiquetaRepository;
import com.FeedbackAmigo.demo.service.EvaletiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class EvaletiquetaServiceImpl implements EvaletiquetaService {
        @Autowired
        private final EvaletiquetaRepository repository;
        @Autowired
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
        public List<EvaletiquetaDto> findByEvaluacion(Long idEvaluacion) {
            return repository.findByIdEvaluacion(idEvaluacion)
                    .stream()
                    .map(mapper::toDto)
                    .toList();
        }
    }

