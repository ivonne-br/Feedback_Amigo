-- Base de datos: Feedback_Amigo
CREATE DATABASE IF NOT EXISTS Feedback;
USE Feedback;

-- Tabla: Licenciatura
CREATE TABLE IF NOT EXISTS licenciatura (
                                            id_licenciatura INT PRIMARY KEY AUTO_INCREMENT,
                                            nombre VARCHAR(100) NOT NULL,
                                            departamento VARCHAR(100)
) ENGINE = InnoDB;

INSERT INTO licenciatura (
    nombre,
    departamento
) VALUES (
             'Humanidades',
             'DSCH'
         );

SELECT * FROM licenciatura;