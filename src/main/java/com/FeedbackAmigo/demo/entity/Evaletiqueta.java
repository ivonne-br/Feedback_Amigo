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
    private Etiqueta idEtiqueta;

    @ManyToOne
    @JoinColumn(name = "id_uea", referencedColumnName = "id", nullable = false)
    private UEAEntity idUeaEntity;

// Getters y setters
public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdEvaluacion() { return idEvaluacion; }
    public void setIdEvaluacion(Long idEvaluacion) { this.idEvaluacion = idEvaluacion; }

    public Long getIdAlumnoEvaluado() { return idAlumnoEvaluado; }
    public void setIdAlumnoEvaluado(Long idAlumnoEvaluado) { this.idAlumnoEvaluado = idAlumnoEvaluado; }

    public Long getIdAlumnoEvaluador() { return idAlumnoEvaluador; }
    public void setIdAlumnoEvaluador(Long idAlumnoEvaluador) { this.idAlumnoEvaluador = idAlumnoEvaluador; }

    public Etiqueta getIdEtiqueta() { return idEtiqueta; }
    public void setIdEtiqueta(Etiqueta idEtiqueta) { this.idEtiqueta = idEtiqueta; }

    public UEAEntity getIdUea() { return idUeaEntity; }
    public void setIdUea(UEAEntity idUeaEntity) { this.idUeaEntity = idUeaEntity; }
}
