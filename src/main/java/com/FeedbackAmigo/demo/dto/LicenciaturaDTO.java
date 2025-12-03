package com.FeedbackAmigo.demo.dto;

public class LicenciaturaDTO {
    private Long id_licenciatura;
    private String nombre;
    private String departamento;

    public Long getId_licenciatura() {
        return id_licenciatura;
    }
    public void setId_licenciatura(Long id_licenciatura) {this.id_licenciatura = id_licenciatura;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}