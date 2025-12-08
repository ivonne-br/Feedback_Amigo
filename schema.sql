-- Base de datos: Feedback_Amigo
CREATE DATABASE IF NOT EXISTS Feedback;
use Feedback;

-- Tabla: Licenciatura
CREATE TABLE IF NOT EXISTS licenciatura (
                                            id_licenciatura INT PRIMARY KEY AUTO_INCREMENT,
                                            nombre VARCHAR(100) NOT NULL,
    departamento VARCHAR(100)
    );



-- Tabla: Alumno
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

-- Tabla uea
CREATE TABLE IF NOT EXISTS ueas(
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   nombre VARCHAR(100) NOT NULL
    ) ENGINE InnoDB;


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

CREATE TABLE  IF NOT EXISTS pregunta (
                            `id_pregunta` int NOT NULL AUTO_INCREMENT,
                            `texto_pregunta` varchar(255) NOT NULL,
                            `categoria` varchar(50) DEFAULT NULL,
                            `estado` varchar(25) DEFAULT NULL,
                            PRIMARY KEY (`id_pregunta`));

-- Tabla respuesta
CREATE TABLE IF NOT EXISTS respuesta (
                                         id_respuesta INT PRIMARY KEY AUTO_INCREMENT,
                                         valor INT,
                                         id_pregunta INT,
                                         id_evaluacion INT,
                                         FOREIGN KEY (id_pregunta) REFERENCES pregunta(id_pregunta),
    FOREIGN KEY (id_evaluacion) REFERENCES evaluacion(id_evaluacion)
    );

-- Tabla  etiqueta

CREATE TABLE if NOT EXISTS etiqueta (
                                        id_etiqueta INT PRIMARY KEY AUTO_INCREMENT,
                                        texto VARCHAR(50)
    );

