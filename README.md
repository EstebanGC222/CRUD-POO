# Sistema de Gestión Médica (Consola)

[![Lenguaje](https://img.shields.io/badge/Lenguaje-Java-blue)](https://www.java.com/)

Este proyecto es una aplicación de consola en Java que simula un sistema básico de gestión médica. Permite la administración de pacientes, médicos y citas, así como la gestión de informes médicos. La interacción con el usuario se realiza a través de menús en la consola.

## Descripción General

El sistema ofrece dos roles principales de usuario: Administrador y Doctor, cada uno con un conjunto de funcionalidades específicas accesibles a través de un menú interactivo.

**Funcionalidades del Administrador:**
*   Gestión CRUD (Crear, Leer, Actualizar, Eliminar) para Pacientes.
*   Gestión CRUD para Médicos.
*   Gestión CRUD para Citas médicas.
*   Acceso a los informes médicos de los pacientes.

**Funcionalidades del Doctor:**
*   Visualización de su agenda de citas.
*   Modificación de sus citas.
*   Agregación de informes médicos a los pacientes.
*   Acceso a los informes médicos de los pacientes que tiene asignados.

## Estructura del Proyecto

El proyecto está contenido dentro de la carpeta `src/` y se compone de las siguientes clases principales:

*   `Main.java`: Punto de entrada de la aplicación. Contiene el menú principal para seleccionar el tipo de usuario (Administrador o Doctor) e inicializa los datos.
*   `Administrador.java`: Define la lógica y el menú para las funcionalidades del administrador.
*   `Doctor.java`: Define la lógica y el menú para las funcionalidades del doctor.
*   `Paciente.java`: Clase modelo que representa a un paciente, incluyendo sus datos personales y una lista de informes médicos.
*   `Medico.java`: Clase modelo que representa a un médico, incluyendo su nombre y especialidad.
*   `Cita.java`: Clase modelo que representa una cita médica, asociando un paciente, un médico y una fecha/hora.
*   `InformeMedico.java`: Clase modelo que representa un informe médico, con descripción y fecha.



## Tecnologías Utilizadas

*   **Lenguaje de Programación:** Java
*   **Entrada/Salida:** `java.util.Scanner` para la entrada por consola, `System.out.println` para la salida.
*   **Manejo de Fechas y Horas:** `java.time.LocalDateTime`, `java.time.LocalDate`, `java.time.format.DateTimeFormatter`.
*   **Colecciones:** `java.util.List` y `java.util.ArrayList` para almacenar los datos en memoria.


## Flujo Básico de Uso

1.  Al iniciar la aplicación, se presenta un menú para seleccionar el tipo de usuario: Administrador o Doctor.
2.  **Si se selecciona Administrador:**
    *   Se accede a un menú con opciones para gestionar pacientes (crear, ver, actualizar, eliminar), médicos, citas, o ver informes.
    *   Para crear una cita, por ejemplo, se listarán los pacientes y médicos existentes para seleccionarlos por ID.
3.  **Si se selecciona Doctor:**
    *   Se accede a un menú para ver la agenda, agregar informes a pacientes o ver informes existentes.

## Consideraciones y Posibles Mejoras

*   **Persistencia de Datos:** Actualmente, todos los datos (pacientes, médicos, citas) se almacenan en memoria y se pierden al cerrar la aplicación. Una mejora significativa sería implementar persistencia utilizando archivos (CSV, JSON, XML) o una base de datos (SQLite, H2, MySQL, etc.).
*   **Manejo de Errores:** Mejorar la validación de entradas (por ejemplo, para fechas, IDs, opciones de menú) y el manejo de excepciones.
*   **Interfaz de Usuario:** Para una aplicación más amigable, se podría desarrollar una interfaz gráfica (GUI) utilizando Java Swing, JavaFX, o una interfaz web.
*   **Autenticación y Seguridad:** Implementar un sistema de inicio de sesión más robusto.
*   **Lógica de Negocio:** Expandir las funcionalidades, por ejemplo, asignación automática de médicos, recordatorios de citas, etc.
*   **Estructura de Paquetes:** Para proyectos más grandes, organizar las clases en paquetes (por ejemplo, `com.example.model`, `com.example.service`, `com.example.ui`) mejoraría la organización.
*   **Generación de IDs:** La generación actual de IDs es secuencial y simple. Para un sistema real, se necesitarían IDs únicos más robustos.

---
*Este proyecto es una simulación básica con fines educativos para demostrar conceptos de programación orientada a objetos y gestión de datos en memoria.*
