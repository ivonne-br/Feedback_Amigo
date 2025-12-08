package com.FeedbackAmigo.demo.dto;

public class EvaletiquetaDto {
    private Long id;
    private Long idEvaluacion;
    private Long idAlumnoEvaluado;
    private Long idAlumnoEvaluador;
    private EtiquetaDTO etiqueta;
    private UEADto ueaEntity;

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

    public EtiquetaDTO getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(EtiquetaDTO etiqueta) {
        this.etiqueta = etiqueta;
    }

    public UEADto getUeaEntity() {
        return ueaEntity;
    }

    public void setUeaEntity(UEADto ueaEntity) {
        this.ueaEntity = ueaEntity;
    }
}