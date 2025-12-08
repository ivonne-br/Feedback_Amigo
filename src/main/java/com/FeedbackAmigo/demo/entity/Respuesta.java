package com.FeedbackAmigo.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "respuesta")
public class Respuesta {
    @Id
    @Column(name = "id_respuesta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRespuesta;
    private int valor;


    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id_pregunta", nullable = false)
    private Pregunta pregunta;

    @ManyToOne
    @JoinColumn(name = "id_evaluacion", referencedColumnName = "id_evaluacion", nullable = false)
    private Evaluacion evaluacion;

    public Long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
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

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }
}
