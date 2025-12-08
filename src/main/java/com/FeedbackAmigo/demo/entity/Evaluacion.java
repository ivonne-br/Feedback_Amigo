package com.FeedbackAmigo.demo.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "evaluacion")
public class Evaluacion {
    @Id
    @Column(name = "id_evaluacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluacion;

    @ManyToOne
    @JoinColumn(name = "id_alumno_evaluador", nullable = false)
    private Alumno alumnoEvaluador;

    @ManyToOne
    @JoinColumn(name = "id_alumno_evaluado", nullable = false)
    private Alumno alumnoEvaluado;

    private boolean anonimo;

    @Column(name = "fecha_evaluacion")
    private String fechaEvaluacion;

    private String comentarios;

    private int calificacion;

    // UEA de la evaluación
    @ManyToOne
    @JoinColumn(name = "id_uea", nullable = false)
    private UEAEntity uea;

    public Long getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
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

    public UEAEntity getUea() {
        return uea;
    }

    public void setUea(UEAEntity uea) {
        this.uea = uea;
    }
}
