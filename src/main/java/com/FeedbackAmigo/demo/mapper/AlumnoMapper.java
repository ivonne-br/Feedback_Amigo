package com.FeedbackAmigo.demo.mapper;

import com.FeedbackAmigo.demo.dto.AlumnoDTO;
import com.FeedbackAmigo.demo.entity.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {LicenciaturaMapper.class}
)
public interface AlumnoMapper {

    @Mapping(source = "idAlumno", target = "idAlumno")
    AlumnoDTO toAlumnoDTO(Alumno alumno);

    @Mapping(target = "idAlumno", ignore = true)
    Alumno toAlumno(AlumnoDTO alumnoDTO);
}