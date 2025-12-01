package com.FeedbackAmigo.demo.dto;

public class AlumnoDTO {
    private Long idAlumno;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String matricula;
    private String email;
    private String password;

    private LicenciaturaDTO licenciatura;

    // Getters & Setters
    public Long getIdAlumno() {
        return idAlumno;
    }
    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public LicenciaturaDTO getLicenciatura() {
        return licenciatura;
    }
    public void setLicenciatura(LicenciaturaDTO licenciatura) {
        this.licenciatura = licenciatura;
    }
}
