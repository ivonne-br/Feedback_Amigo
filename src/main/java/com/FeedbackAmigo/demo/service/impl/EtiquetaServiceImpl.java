package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.EtiquetaDTO;
import com.FeedbackAmigo.demo.entity.Etiqueta;
import com.FeedbackAmigo.demo.mapper.EtiquetaMapper;
import com.FeedbackAmigo.demo.repository.EtiquetaRepository;
import com.FeedbackAmigo.demo.service.EtiquetaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class EtiquetaServiceImpl implements EtiquetaService {
    private final EtiquetaRepository etiquetaRepository;
    private final EtiquetaMapper etiquetaMapper;

    public EtiquetaServiceImpl(EtiquetaRepository etiquetaRepository, EtiquetaMapper etiquetaMapper) {
        this.etiquetaRepository = etiquetaRepository;
        this.etiquetaMapper = etiquetaMapper;

    }

    @Override
    public List<EtiquetaDTO> getEtiquetas(){
        List<Etiqueta> etiquetas = etiquetaRepository.findAll();
        List<EtiquetaDTO> dtos = new LinkedList<>();
        for (Etiqueta etiqueta : etiquetas) {
            dtos.add(etiquetaMapper.toEtiquetaDTO(etiqueta));
        }
        return dtos;
    }

    @Override
    public EtiquetaDTO getEtiquetaById(Long id){
        Etiqueta etiqueta = etiquetaRepository.findById(id).orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));
        return etiquetaMapper.toEtiquetaDTO(etiqueta);
    }

    @Override
    public EtiquetaDTO save(EtiquetaDTO etiquetaDTO){
        Etiqueta etiqueta = etiquetaMapper.toEtiqueta(etiquetaDTO);
        etiqueta = etiquetaRepository.save(etiqueta);
        return etiquetaMapper.toEtiquetaDTO(etiqueta);
    }

    @Override
    public EtiquetaDTO update(Long id, EtiquetaDTO etiquetaDTO){
        Etiqueta etiqueta = etiquetaRepository.findById(id).orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));

        etiqueta.setTexto(etiquetaDTO.getTexto());

        etiqueta = etiquetaRepository.save(etiqueta);
        return etiquetaMapper.toEtiquetaDTO(etiqueta);
    }

    @Override
    public void delete(Long id){
        if(!etiquetaRepository.existsById(id)){
            throw new RuntimeException("Etiqueta no encontrada");
        }
        etiquetaRepository.deleteById(id);
    }
}
