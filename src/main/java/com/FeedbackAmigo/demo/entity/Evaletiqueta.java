package com.FeedbackAmigo.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "evaletiqueta")
public class Evaletiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_evaluacion", nullable = false)
    private Long idEvaluacion;

    @Column(name = "id_alumno_evaluado", nullable = false)
    private Long idAlumnoEvaluado;

    @Column(name = "id_alumno_evaluador", nullable = false)
    private Long idAlumnoEvaluador;

    @ManyToOne
    @JoinColumn(name = "id_etiqueta", referencedColumnName = "id_etiqueta", nullable = false)
    private Etiqueta etiqueta;

    @ManyToOne
    @JoinColumn(name = "id_uea", referencedColumnName = "id", nullable = false)
    private UEAEntity ueaEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Long getIdAlumnoEvaluado() {
        return idAlumnoEvaluado;
    }

    public void setIdAlumnoEvaluado(Long idAlumnoEvaluado) {
        this.idAlumnoEvaluado = idAlumnoEvaluado;
    }

    public Long getIdAlumnoEvaluador() {
        return idAlumnoEvaluador;
    }

    public void setIdAlumnoEvaluador(Long idAlumnoEvaluador) {
        this.idAlumnoEvaluador = idAlumnoEvaluador;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    public UEAEntity getUeaEntity() {
        return ueaEntity;
    }

    public void setUeaEntity(UEAEntity ueaEntity) {
        this.ueaEntity = ueaEntity;
    }
}
