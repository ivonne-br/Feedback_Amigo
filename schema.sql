-- Base de datos
CREATE DATABASE IF NOT EXISTS Feedback;
USE Feedback;

-- Tabla licenciatura
DROP TABLE IF EXISTS licenciatura;
CREATE TABLE IF NOT EXISTS licenciatura (
                                            id_licenciatura INT PRIMARY KEY AUTO_INCREMENT,
                                            nombre VARCHAR(100) NOT NULL,
    departamento VARCHAR(100)
    );

-- Tabla alumno
DROP TABLE IF EXISTS alumno;
CREATE TABLE IF NOT EXISTS alumno (
                                      id_alumno INT PRIMARY KEY AUTO_INCREMENT,
                                      nombre VARCHAR(100) NOT NULL,
    apellido_p VARCHAR(100),
    apellido_m VARCHAR(100),
    matricula VARCHAR(50) UNIQUE,
    email VARCHAR(150) UNIQUE,
    password VARCHAR(100),
    id_licenciatura INT,
    FOREIGN KEY (id_licenciatura) REFERENCES licenciatura(id_licenciatura)
    );

-- Tabla UEA
DROP TABLE IF EXISTS ueas;
CREATE TABLE IF NOT EXISTS ueas(
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   nombre VARCHAR(100) NOT NULL
    ) ENGINE=InnoDB;

-- Tabla evaluacion
DROP TABLE IF EXISTS evaluacion;
CREATE TABLE IF NOT EXISTS evaluacion (
                                          id_evaluacion INT PRIMARY KEY AUTO_INCREMENT,
                                          id_alumno_evaluador INT,
                                          id_alumno_evaluado INT,
                                          anonimo BOOLEAN,
                                          fecha_evaluacion DATE,
                                          comentarios TEXT,
                                          calificacion INT,
                                          id_uea INT,
                                          FOREIGN KEY (id_alumno_evaluador) REFERENCES alumno(id_alumno),
    FOREIGN KEY (id_alumno_evaluado) REFERENCES alumno(id_alumno),
    FOREIGN KEY (id_uea) REFERENCES ueas(id)
    );

-- Tabla pregunta
DROP TABLE IF EXISTS pregunta;
CREATE TABLE IF NOT EXISTS pregunta (
                                        id_pregunta INT NOT NULL AUTO_INCREMENT,
                                        texto_pregunta VARCHAR(255) NOT NULL,
    categoria VARCHAR(50),
    estado VARCHAR(25),
    PRIMARY KEY (id_pregunta)
    );

-- Tabla respuesta
DROP TABLE IF EXISTS respuesta;
CREATE TABLE IF NOT EXISTS respuesta (
                                         id_evaluacion INT NOT NULL,
                                         id_alumno_evaluador INT NOT NULL,
                                         id_alumno_evaluado INT NOT NULL,
                                         id_uea INT NOT NULL,
                                         id_pregunta INT NOT NULL,
                                         valor INT NOT NULL,

                                         PRIMARY KEY (id_evaluacion, id_alumno_evaluado, id_uea, id_pregunta),

    FOREIGN KEY (id_evaluacion) REFERENCES evaluacion(id_evaluacion),
    FOREIGN KEY (id_alumno_evaluador) REFERENCES alumno(id_alumno),
    FOREIGN KEY (id_alumno_evaluado) REFERENCES alumno(id_alumno),
    FOREIGN KEY (id_uea) REFERENCES ueas(id),
    FOREIGN KEY (id_pregunta) REFERENCES pregunta(id_pregunta)
    );

-- Tabla etiqueta
DROP TABLE IF EXISTS etiqueta;
CREATE TABLE IF NOT EXISTS etiqueta (
                                        id_etiqueta INT PRIMARY KEY AUTO_INCREMENT,
                                        texto VARCHAR(50)
    );

