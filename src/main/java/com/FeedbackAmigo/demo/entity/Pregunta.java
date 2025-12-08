package com.FeedbackAmigo.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "pregunta")
public class Pregunta {

    @Id
    @Column(name = "id_pregunta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPregunta;

    @Column(name = "texto_pregunta", nullable = false, length = 255)
    private String textoPregunta;

    @Column(length = 50)
    private String categoria;

    @Column(length = 25)
    private String estado;

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
