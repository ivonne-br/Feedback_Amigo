-- Base de datos: Feedback_Amigo
CREATE DATABASE IF NOT EXISTS Feedback;
use Feedback;

-- Tabla: Licenciatura
CREATE TABLE licenciatura (
                              id_licenciatura INT PRIMARY KEY AUTO_INCREMENT,
                              nombre VARCHAR(100) NOT NULL,
                              departamento VARCHAR(100)
);

-- Tabla: Alumno
CREATE TABLE alumno (
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

show tables;
