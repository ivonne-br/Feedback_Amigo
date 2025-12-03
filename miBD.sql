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

INSERT INTO alumno (
    nombre,
    apellido_p,
    apellido_m,
    matricula,
    email,
    password,
    id_licenciatura
) VALUES
      (
          'Ivonne',
          'Hernández',
          'López',
          '12345',
          'ivonne@correo.com',
          '12345',
          1
      ),
      (
          'Carlos',
          'Ramírez',
          'Santos',
          '67890',
          'carlos@correo.com',
          '12345',
          1
      );

SELECT * FROM alumno;

CREATE TABLE IF NOT EXISTS UEA(
                                  id INT PRIMARY KEY AUTO_INCREMENT,
                                  nombre VARCHAR(100) NOT NULL
) ENGINE InnoDB;

INSERT INTO UEA(
    nombre)
VALUES(
          'Laboratorio Tematico III'
      );


CREATE TABLE IF NOT EXISTS EvalEtiqueta(
                                  id INT PRIMARY KEY AUTO_INCREMENT,
                                  id_etiqueta INT,
                                  FOREIGN KEY (id_etiqueta) references Etiqueta(id_etiqueta)
) ENGINE InnoDB;

INSERT INTO EvalEtiqueta(
    id, id_etiqueta)
VALUES(
          1, 1
      );
