package com.FeedbackAmigo.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RespuestaId implements Serializable {
    private Long idEvaluacion;
    private Long  idAlumnoEvaluador;
    private Long idAlumnoEvaluado;
    private Long idUea;
    private Long idPregunta;

    public RespuestaId() {}

    public RespuestaId(Long idEvaluacion, Long  idAlumnoEvaluador, Long idAlumnoEvaluado, Long idUea, Long idPregunta) {
       this.idEvaluacion = idEvaluacion;
        this.idAlumnoEvaluador = idAlumnoEvaluador;
        this.idAlumnoEvaluado = idAlumnoEvaluado;
        this.idUea = idUea;
        this.idPregunta = idPregunta;
    }

    public Long getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    public Long getIdAlumnoEvaluador() {
        return idAlumnoEvaluador;
    }

    public void setIdAlumnoEvaluador(Long idAlumnoEvaluador) {
        this.idAlumnoEvaluador = idAlumnoEvaluador;
    }

    public Long getIdAlumnoEvaluado() {
        return idAlumnoEvaluado;
    }

    public void setIdAlumnoEvaluado(Long idAlumnoEvaluado) {
        this.idAlumnoEvaluado = idAlumnoEvaluado;
    }

    public Long getIdUea() {
        return idUea;
    }

    public void setIdUea(Long idUea) {
        this.idUea = idUea;
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RespuestaId that)) return false;
        return idEvaluacion == that.idEvaluacion && idAlumnoEvaluador == that.idAlumnoEvaluador && idAlumnoEvaluado == that.idAlumnoEvaluado && idUea == that.idUea && idPregunta == that.idPregunta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvaluacion, idAlumnoEvaluador, idAlumnoEvaluado, idUea, idPregunta);
    }
}
