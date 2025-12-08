-- Licenciatura
INSERT INTO licenciatura (nombre, departamento) VALUES
                                                    ('Humanidades', 'DSCH'),
                                                    ('Ingeniería en Computación', 'CNI'),
                                                    ('Matemáticas Aplicadas', 'CNI'),
                                                    ('Comunicación', 'CCD'),
                                                    ('Diseño', 'CCD'),
                                                    ('TSI', 'CCD');

-- Alumno
INSERT INTO alumno (nombre, apellido_p, apellido_m, matricula, email, password, id_licenciatura) VALUES
                                                                                                     ('Ivonne','Hernández','López','12345','ivonne@correo.com','12345',1),
                                                                                                     ('Carlos','Ramírez','Santos','67890','carlos@correo.com','12345',1),
                                                                                                     ('Sebastián', 'Reyes', 'García', '45789', 'sebastian@correo.com', 'pass123',6),
                                                                                                     ('Ana', 'González', 'Hernandez', '33445', 'ana.gonzalez@correo.com', 'pass234',2),
                                                                                                     ('Carlos', 'Martínez', 'Vega', '88991', 'carlos.martinez@correo.com', 'pass178',4),
                                                                                                     ('María', 'Flores', 'Rojas', '55214', 'maria.flores@correo.com', 'pass777',3),
                                                                                                     ('Jorge', 'Santos', 'Mendoza', '22110', 'jorge.santos@correo.com', 'pass999',6);

-- UEA
INSERT INTO ueas (nombre) VALUES
                              ('Laboratorio Temático 3'),
                              ('Matemáticas I'),
                              ('Programación Estructurada'),
                              ('Bases de Datos'),
                              ('Estructuras de Datos'),
                              ('Sistemas Operativos'),
                              ('Algoritmos'),
                              ('Redes de Computadoras'),
                              ('Inteligencia Artificial');

-- Pregunta
INSERT INTO pregunta(texto_pregunta, categoria, estado) VALUES
                                                            ('Del 1 al 5, ¿Cómo calificarías la participación en clase?', 'Participación', 'Activa'),
                                                            ('Del 1 al 5, ¿Cómo calificarías la puntualidad?', 'Asistencia', 'Activa'),
                                                            ('Del 1 al 5, ¿Cómo calificarías la responsabilidad en las tareas?', 'Responsabilidad', 'Activa'),
                                                            ('Del 1 al 5, ¿Cómo calificarías la colaboración con tus compañeros?', 'Trabajo en equipo', 'Activa'),
                                                            ('Del 1 al 5, ¿Cómo calificarías la creatividad?', 'Habilidad', 'Activa'),
                                                            ('Del 1 al 5, ¿Cómo calificarías la comprensión del tema?', 'Conocimiento', 'Activa'),
                                                            ('Del 1 al 5, ¿Cómo calificarías la claridad al exponer?', 'Comunicación', 'Activa'),
                                                            ('Del 1 al 5, ¿Cómo calificarías la disciplina en el proyecto?', 'Disciplina', 'Activa'),
                                                            ('Del 1 al 5, ¿Cómo calificarías la puntualidad en entregas?', 'Asistencia', 'Activa'),
                                                            ('Del 1 al 5, ¿Cómo calificarías la actitud ante el aprendizaje?', 'Actitud', 'Activa');

-- Evaluaciones
INSERT INTO evaluacion (
    id_alumno_evaluador,
    id_alumno_evaluado,
    anonimo,
    fecha_evaluacion,
    comentarios,
    calificacion,
    id_uea
) VALUES
      (1, 2, false, '2025-12-02', 'Muy buen trabajo en equipo y participación.', 5, 3),
      (2, 3, true, '2025-12-03', 'Es comprometido', 4, 2),
      (3, 4, false, '2025-12-01', 'Es puntual', 3, 2),
      (4, 1, false, '2025-11-29', 'Es poco responsable', 2, 1);

-- Respuestas
INSERT INTO respuesta VALUES
                          (1, 1, 2, 3, 1, 4),
                          (1, 1, 2, 3, 2, 5),
                          (2, 2, 3, 2, 1, 3),
                          (2, 2, 3, 2, 3, 4),
                          (3, 3, 4, 2, 5, 2);

-- Etiquetas
INSERT INTO etiqueta(texto) VALUES
                                ('Buena puntualidad'),
                                ('Compromiso'),
                                ('Responsabilidad'),
                                ('Amplio conocimiento del tema');
