# Casos de Uso para Drivers Arquitectónicos

---

## 1. Registrar una evaluación de un compañero

**Actor:** Alumno  
**Descripción:** Un alumno selecciona a un compañero, responde las preguntas y califica su desempeño (1–5), elige si desea anonimato y envía la evaluación.

### Drivers involucrados
- **Seguridad y anonimato:** garantizar privacidad del evaluador.  
- **Integridad de datos:** registro confiable y validado en la base de datos.  
- **Rendimiento:** respuesta rápida al enviar evaluación.

### Implicaciones arquitectónicas
- Capa de negocio con lógica de anonimato.  
- Base de datos con relaciones seguras y triggers o procedimientos para anonimizar datos.  
- Backend asíncrono (Node.js / PHP) para reducir latencia.

---

## 2. Consultar promedios y estadísticas de compañeros

**Actor:** Alumno  
**Descripción:** Permite visualizar el promedio de calificaciones, etiquetas y estadísticas de desempeño.

### Drivers involucrados
- **Rendimiento:** consultas agregadas eficientes.  
- **Escalabilidad:** múltiples usuarios consultando simultáneamente.  
- **Usabilidad:** interfaz clara, tablas y gráficas intuitivas.

### Implicaciones arquitectónicas
- Índices y vistas materializadas en la base de datos.  
- API REST optimizada con endpoints `/estadisticas/:idAlumno`.  
- Frontend con componentes gráficos (React + Recharts).

---

## 3. Autenticación

**Actor:** Alumno  
**Descripción:** Permite iniciar sesión, registrar cuenta.

### Drivers involucrados
- **Seguridad:** encriptación de contraseñas, autenticación JWT o sesión segura.  
- **Usabilidad:** inicio de sesión simple y rápido.

### Implicaciones arquitectónicas
- Middleware de autenticación.  
- Hash de contraseñas (bcrypt).  
- Tokens JWT almacenados de forma segura (cookies HTTP-only o localStorage).

---

## 4. Administración del sistema (Preguntas, Etiquetas, Licenciaturas, UEA)

**Actor:** Administrador  
**Descripción:** Permite registrar, modificar o eliminar elementos del sistema.

### Drivers involucrados
- **Mantenibilidad:** arquitectura modular y CRUD reutilizables.  
- **Escalabilidad:** posibilidad de agregar nuevas licenciaturas o UEAs sin alterar la estructura base.

### Implicaciones arquitectónicas
- Backend con controladores REST genéricos.  
- Base de datos relacional normalizada con claves foráneas.  
- Panel de administración con autenticación.

---

## 6. Experiencia de usuario (Frontend responsivo)

**Actor:** Cualquier usuario  
**Descripción:** Navegar por la plataforma desde PC o dispositivo móvil.

### Drivers involucrados
- **Usabilidad y accesibilidad:** diseño responsive, navegación clara.  
- **Rendimiento del cliente:** carga rápida y eficiente.

### Implicaciones arquitectónicas
- Framework moderno (React/Vue) + Tailwind/Bootstrap.  
- Lazy loading de componentes.  
- API RESTful eficiente en peticiones.

---

## 7. Escalabilidad del sistema

**Actor:** Sistema (interno)  
**Descripción:** El sistema debe permitir agregar nuevas carreras, UEAs y alumnos sin rediseñar la arquitectura.

### Drivers involucrados
- **Escalabilidad horizontal:** fácil despliegue en múltiples servidores.  
- **Mantenibilidad:** código desacoplado.

### Implicaciones arquitectónicas
- Separación de capas: frontend / API / base de datos.  
- Uso de ORM (Sequelize o Prisma) para abstracción de datos.  
- Arquitectura modular o de microservicios.

---