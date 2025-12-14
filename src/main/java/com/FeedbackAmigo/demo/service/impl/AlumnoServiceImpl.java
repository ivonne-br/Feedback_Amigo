package com.FeedbackAmigo.demo.service.impl;

import com.FeedbackAmigo.demo.dto.AlumnoDTO;
import com.FeedbackAmigo.demo.entity.Alumno;
import com.FeedbackAmigo.demo.entity.Licenciatura;
import com.FeedbackAmigo.demo.mapper.AlumnoMapper;
import com.FeedbackAmigo.demo.mapper.LicenciaturaMapper;
import com.FeedbackAmigo.demo.repository.AlumnoRepository;
import com.FeedbackAmigo.demo.repository.LicenciaturaRepository;
import com.FeedbackAmigo.demo.service.AlumnoService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final LicenciaturaRepository licenciaturaRepository;
    private final AlumnoMapper alumnoMapper;
    private final LicenciaturaMapper licenciaturaMapper;

    public AlumnoServiceImpl(
            AlumnoRepository alumnoRepository,
            LicenciaturaRepository licenciaturaRepository,
            AlumnoMapper alumnoMapper, LicenciaturaMapper licenciaturaMapper) {
        this.alumnoRepository = alumnoRepository;
        this.licenciaturaRepository = licenciaturaRepository;
        this.alumnoMapper = alumnoMapper;
        this.licenciaturaMapper = licenciaturaMapper;
    }

    @Override
    public List<AlumnoDTO> findAll() {
        return alumnoRepository.findAll()
                .stream()
                .map(alumnoMapper::toAlumnoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AlumnoDTO> findById(Long id) {
        return alumnoRepository.findById(id)
                .map(alumnoMapper::toAlumnoDTO);
    }

    @Override
    public AlumnoDTO save(AlumnoDTO dto) {
        Licenciatura licenciatura = null;
        if (dto.getLicenciatura() != null && dto.getLicenciatura().getId_licenciatura() != null) {
            licenciatura = licenciaturaRepository.findById(dto.getLicenciatura().getId_licenciatura())
                    .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Licenciatura no encontrada"));
        }

        Alumno alumno = alumnoMapper.toAlumno(dto);
        alumno.setLicenciatura(licenciatura);

        alumno = alumnoRepository.save(alumno);

        return alumnoMapper.toAlumnoDTO(alumno);
    }

    @Override
    public Optional<AlumnoDTO> findById(long id){
        return  alumnoRepository.findById(id).map(alumnoMapper::toAlumnoDTO);
    }

    @Override
    public List<AlumnoDTO> buscarPorNombreParcial(String nombre){
        return alumnoRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(alumnoMapper::toAlumnoDTO)
                .toList();

    }

    @Override
    public List<AlumnoDTO> buscarPorNombreExacto(String nombre, String apellidoP, String apellidoM) {

        List<Alumno> alumnos = alumnoRepository
                .findByNombreIgnoreCaseAndApellidoPIgnoreCaseAndApellidoMIgnoreCase(nombre, apellidoP, apellidoM);

        return alumnos.stream()
                .map(alumnoMapper::toAlumnoDTO)
                .toList();
    }

    @Override
    public void update(long id, AlumnoDTO dto){
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno con ID" + id + "no encontrado"));

        Licenciatura licenciatura = null;
        if (dto.getLicenciatura() != null && dto.getLicenciatura().getId_licenciatura() != null) {
            licenciatura = licenciaturaRepository.findById(dto.getLicenciatura().getId_licenciatura())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Licenciatura no encontrada"));
        }

        alumno.setNombre(dto.getNombre());
        alumno.setApellidoP(dto.getApellidoP());
        alumno.setApellidoM(dto.getApellidoM());
        alumno.setMatricula(dto.getMatricula());
        alumno.setEmail(dto.getEmail());
        alumno.setPassword(dto.getPassword());
        alumno.setLicenciatura(licenciatura);

        alumnoRepository.save(alumno);
    }

    @Override
    public void deleteById(Long id) {
        if (!alumnoRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado");

        alumnoRepository.deleteById(id);
    }

    @Override
    public void deleteAll(){
        alumnoRepository.deleteAll();
    }
}