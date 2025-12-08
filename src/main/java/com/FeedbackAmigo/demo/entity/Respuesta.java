package com.FeedbackAmigo.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "respuesta")
public class Respuesta {
    @EmbeddedId

    private RespuestaId id;
    private int valor;


    @ManyToOne
    @MapsId("idPregunta")
    @JoinColumn(name = "id_pregunta", nullable = false)
    private Pregunta pregunta;

    @ManyToOne
    @MapsId("idAlumnoEvaluador")
    @JoinColumn(name = "id_alumno_evaluador", nullable = false)
    private Alumno alumnoEvaluador;

    @ManyToOne
    @MapsId("idAlumnoEvaluado")
    @JoinColumn(name = "id_alumno_evaluado", nullable = false)
    private Alumno alumnoEvaluado;

    @ManyToOne
    @MapsId("idUea")
    @JoinColumn(name = "id_uea",  nullable = false)
    private UEAEntity uea;

    public RespuestaId getId() {
        return id;
    }

    public void setId(RespuestaId id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Alumno getAlumnoEvaluador() {
        return alumnoEvaluador;
    }

    public void setAlumnoEvaluador(Alumno alumnoEvaluador) {
        this.alumnoEvaluador = alumnoEvaluador;
    }

    public Alumno getAlumnoEvaluado() {
        return alumnoEvaluado;
    }

    public void setAlumnoEvaluado(Alumno alumnoEvaluado) {
        this.alumnoEvaluado = alumnoEvaluado;
    }

    public UEAEntity getUea() {
        return uea;
    }

    public void setUea(UEAEntity uea) {
        this.uea = uea;
    }
}
