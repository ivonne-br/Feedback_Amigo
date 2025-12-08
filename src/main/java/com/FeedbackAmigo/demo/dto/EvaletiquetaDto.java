package com.FeedbackAmigo.demo.dto;

public class EvaletiquetaDto {
    private Long id;
    private Long idEvaluacion;
    private Long idAlumnoEvaluado;
    private Long idAlumnoEvaluador;
    private EtiquetaDTO idEtiqueta;
    private UEADto idUea;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdEvaluacion() { return idEvaluacion; }
    public void setIdEvaluacion(Long idEvaluacion) { this.idEvaluacion = idEvaluacion; }

    public Long getIdAlumnoEvaluado() { return idAlumnoEvaluado; }
    public void setIdAlumnoEvaluado(Long idAlumnoEvaluado) { this.idAlumnoEvaluado = idAlumnoEvaluado; }

    public Long getIdAlumnoEvaluador() { return idAlumnoEvaluador; }
    public void setIdAlumnoEvaluador(Long idAlumnoEvaluador) { this.idAlumnoEvaluador = idAlumnoEvaluador; }

    public EtiquetaDTO getIdEtiqueta() { return idEtiqueta; }
    public void setIdEtiqueta(EtiquetaDTO idEtiqueta) { this.idEtiqueta = idEtiqueta; }

    public UEADto getIdUea() { return idUea; }
    public void setIdUea(UEADto idUea) { this.idUea = idUea; }
}
