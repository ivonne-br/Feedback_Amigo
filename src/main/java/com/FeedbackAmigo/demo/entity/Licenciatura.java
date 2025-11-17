package com.FeedbackAmigo.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "licenciatura")

public class Licenciatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_licenciatura;
    private String nombre;
    private String departamento;

    public long getId_licenciatura() {
        return id_licenciatura;
    }
    public void setId_licenciatura(long id_licenciatura) {
        this.id_licenciatura = id_licenciatura;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
