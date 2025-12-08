package com.FeedbackAmigo.demo.dto;

import com.FeedbackAmigo.demo.entity.Alumno;
import com.FeedbackAmigo.demo.entity.UEA;

public class EvaluacionDTO {

    private Long idEvaluacion;
    private Long idAlumnoEvaluador;
    private Long idAlumnoEvaluado;
    private boolean anonimo;
    private String fechaEvaluacion;
    private String comentarios;
    private int calificacion;
    private Long idUea;


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

    public boolean isAnonimo() {
        return anonimo;
    }

    public void setAnonimo(boolean anonimo) {
        this.anonimo = anonimo;
    }

    public String getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(String fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Long getIdUea() {
        return idUea;
    }

    public void setIdUea(Long idUea) {
        this.idUea = idUea;
    }
}

