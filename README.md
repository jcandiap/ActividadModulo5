# ✈️ AeroFly - Sistema de Reservas de Vuelos

![Status](https://img.shields.io/badge/status-Active-success.svg)
![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![JakartaEE](https://img.shields.io/badge/JakartaEE-10-blue.svg)

> Aplicación web robusta desarrollada bajo el patrón **MVC** (Modelo-Vista-Controlador) y **DAO** (Data Access Object) para la gestión integral de reservas de vuelos comerciales.

---

## 📋 Descripción

Este proyecto es una solución integral para una aerolínea que permite a los usuarios visualizar vuelos en tiempo real y realizar reservaciones de manera sencilla y segura. La arquitectura está diseñada para separar claramente las responsabilidades, facilitando el mantenimiento y la escalabilidad.

### ✨ Características Principales

*   **🏗️ Arquitectura MVC Prolija:** Separación total entre la lógica de negocio (Servlets), el acceso a datos (DAOs) y la interfaz de usuario (JSPs).
*   **💾 Patrón de Diseño DAO:** Capa de abstracción de datos utilizando JDBC, permitiendo cambiar el motor de persistencia sin afectar la lógica superior.
*   **🎨 Interfaz Moderna con Bootstrap 5:** Diseño responsivo y atractivo que garantiza una excelente experiencia de usuario en cualquier dispositivo.
*   **🐳 Despliegue con Docker:** Contenerización completa de la aplicación y la base de datos para asegurar consistencia en cualquier entorno.
*   **🛡️ Validación de Datos:** Implementación de reglas de negocio en el lado del servidor para asegurar la integridad de las reservaciones.
*   **📖 Documentación JavaDoc:** Código fuente totalmente documentado en español siguiendo estándares profesionales.

---

## 🔍 Modelo de Datos

El sistema utiliza una base de datos relacional MySQL con el siguiente esquema:

### 1. Tabla `flights` (Vuelos)
Almacena la información de los trayectos disponibles.
*   `id`: Identificador único (Primary Key).
*   `flight_number`: Código alfanumérico único del vuelo (ej. AF101).
*   `origin`: Ciudad o aeropuerto de origen.
*   `destination`: Ciudad o aeropuerto de destino.
*   `departure_time`: Horario programado de salida.

### 2. Tabla `bookings` (Reservas)
Registra las transacciones de reserva realizadas por los pasajeros.
*   `id`: Identificador único (Primary Key).
*   `flight_id`: Referencia al vuelo (Foreign Key vinculada a `flights.id`).
*   `passenger_name`: Nombre completo del pasajero.
*   `email`: Correo electrónico de contacto.
*   `created_at`: Marca de tiempo de la creación del registro.

---

## 🛠️ Tecnologías Utilizadas

| Tecnología | Descripción |
| :--- | :--- |
| **Java 17** | Lenguaje de programación principal. |
| **Jakarta EE / Servlets** | Framework para el manejo de peticiones HTTP. |
| **MySQL 8.0** | Motor de base de datos relacional. |
| **JDBC** | API para la conexión y ejecución de consultas SQL. |
| **Tomcat 10.1** | Servidor de aplicaciones/Contenedor de Servlets. |
| **Docker & Compose** | Herramientas de contenedores para despliegue. |
| **Bootstrap 5** | Framework de CSS para diseño responsivo. |
| **Maven** | Gestor de dependencias y construcción del proyecto. |

---

## 📂 Estructura del Proyecto

```text
ActividadModulo5/
├── src/main/java/cl/aerofly/
│   ├── controller/    # 🕹️ Controladores (Servlets)
│   ├── dao/           # 🗄️ Interfaces y Clases de Acceso a Datos
│   ├── model/         # 📦 Clases de Entidad (POJOs)
│   └── utils/         # 🛠️ Utilidades (Conexión DB)
├── src/main/webapp/
│   ├── views/         # 🖼️ Páginas JSP (Vistas)
│   └── index.jsp      # 🏠 Página de inicio
├── mysql/
│   └── init.sql       # 🏗️ Script de inicialización de la base de datos
├── Dockerfile         # 🐳 Configuración de imagen Tomcat
├── docker-compose.yml # 🚀 Orquestación de contenedores
└── pom.xml            # 📦 Configuración de Maven
```

---

## 🚀 Instalación y Uso con Docker

El proyecto está configurado para levantarse de forma automática utilizando Docker. Sigue estos pasos:

1.  **Construir el proyecto (Maven):**
    Asegúrate de generar el archivo `.war` antes de construir la imagen.
    ```bash
    mvn clean package
    ```

2.  **Levantar los contenedores:**
    Desde la raíz del proyecto, ejecuta:
    ```bash
    docker-compose up --build
    ```

3.  **Acceder a la aplicación:**
    Una vez que los contenedores estén en ejecución (app en puerto 8080 y db en puerto 3306), abre tu navegador en:
    [http://localhost:8080](http://localhost:8080)

---

## 👨‍💻 Autor

**José Candia**
*   🔗 **LinkedIn:** [linkedin.com/in/jcandiap](https://www.linkedin.com/in/jcandiap/)
*   🐙 **GitHub:** [github.com/jcandiap](https://github.com/jcandiap)
*   📧 **Email:** [joescandia@gmail.com](mailto:joescandia@gmail.com)
