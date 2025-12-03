package com.FeedbackAmigo.demo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "etiqueta")
public class Etiqueta {

    @Id
    @Column(name = "id_etiqueta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtiqueta;

    @Column(length = 50)
    private String texto;

    public Long getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Long idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
