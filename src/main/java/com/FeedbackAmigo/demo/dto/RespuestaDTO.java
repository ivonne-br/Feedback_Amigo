package com.FeedbackAmigo.demo.dto;


public class RespuestaDTO {
private long idAlumnoEvaluador;
private long idAlumnoEvaluado;
private long idUea;
private long idPregunta;
private int valor;


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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
