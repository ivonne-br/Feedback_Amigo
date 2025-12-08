package com.FeedbackAmigo.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RespuestaId implements Serializable {
    private long idEvaluacion;
    private long  idAlumnoEvaluador;
    private long idAlumnoEvaluado;
    private long idUea;
    private long idPregunta;

    public RespuestaId() {}

    public RespuestaId(long idEvaluacion, long  idAlumnoEvaluador, long idAlumnoEvaluado, long idUea, long idPregunta) {
       this.idEvaluacion = idEvaluacion;
        this.idAlumnoEvaluador = idAlumnoEvaluador;
        this.idAlumnoEvaluado = idAlumnoEvaluado;
        this.idUea = idUea;
        this.idPregunta = idPregunta;
    }

    public long getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    public long getIdAlumnoEvaluador() {
        return idAlumnoEvaluador;
    }

    public void setIdAlumnoEvaluador(long idAlumnoEvaluador) {
        this.idAlumnoEvaluador = idAlumnoEvaluador;
    }

    public long getIdAlumnoEvaluado() {
        return idAlumnoEvaluado;
    }

    public void setIdAlumnoEvaluado(long idAlumnoEvaluado) {
        this.idAlumnoEvaluado = idAlumnoEvaluado;
    }

    public long getIdUea() {
        return idUea;
    }

    public void setIdUea(long idUea) {
        this.idUea = idUea;
    }

    public long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(long idPregunta) {
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
