package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.LicenciaturaDTO;
import com.FeedbackAmigo.demo.entity.Licenciatura;
import com.FeedbackAmigo.demo.mapper.LicenciaturaMapper;
import com.FeedbackAmigo.demo.repository.LicenciaturaRepository;
import com.FeedbackAmigo.demo.service.LicenciaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class LicenciaturaServiceImpl implements LicenciaturaService {
    private final LicenciaturaMapper licenciaturaMapper;
    private final LicenciaturaRepository licenciaturaRepository;

    public LicenciaturaServiceImpl(LicenciaturaMapper licenciaturaMapper, LicenciaturaRepository licenciaturaRepository) {
        this.licenciaturaMapper = licenciaturaMapper;
        this.licenciaturaRepository = licenciaturaRepository;
    }

    @Override
    public List<LicenciaturaDTO> findAll() {
        List<Licenciatura> licenciatura = licenciaturaRepository.findAll();
        List<LicenciaturaDTO> licenciaturaDTO = new LinkedList<>();
        for (Licenciatura lic : licenciatura) {
            licenciaturaDTO.add(licenciaturaMapper.toLicenciaturaDTO(lic));
        }
        return licenciaturaDTO;
    }

    @Override
    public LicenciaturaDTO save(LicenciaturaDTO licenciaturaDTO) {
        Licenciatura licenciatura = licenciaturaMapper.toLicenciatura(licenciaturaDTO);
        licenciatura = licenciaturaRepository.save(licenciatura);
        LicenciaturaDTO licenciaturaDTODTO = licenciaturaMapper.toLicenciaturaDTO(licenciatura);

        return licenciaturaDTODTO;
    }

    @Override
    public void deleteById(long id) {
        if (!licenciaturaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Licenciatura no encontrada");
        }
        licenciaturaRepository.deleteById(id);
    }

    @Override
    public void update(long id, LicenciaturaDTO licenciaturaDTO) {
        Licenciatura licenciaturaExistente = licenciaturaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Licenciatura no encontrada"));
        licenciaturaExistente.setNombre(licenciaturaDTO.getNombre());
        licenciaturaExistente.setDepartamento(licenciaturaDTO.getDepartamento());

        licenciaturaRepository.save(licenciaturaExistente);
    }

    @Override
    public Optional<LicenciaturaDTO> findById(long id) {
        return licenciaturaRepository.findById(id).map(licenciaturaMapper::toLicenciaturaDTO);
    }

    @Override
    public boolean existsById(long id) {
        return licenciaturaRepository.existsById(id);
    }

}
