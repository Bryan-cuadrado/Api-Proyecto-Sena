# Api-Proyecto-Sena

Backend REST desarrollado en Java (Jakarta Servlet 6.0) con Apache Maven, desplegado sobre Apache Tomcat y conectado a MySQL mediante JDBC. Provee los servicios de autenticación, gestión de usuarios y solicitudes para el portal `AppIntegracionSena`.

## Requisitos

- Java JDK 17
- Apache Maven 3.9+
- Apache Tomcat 10.1 o superior
- MySQL 8

## Estructura del proyecto

- `src/main/java/com/sena/api/config/` — Conexión JDBC (`ConexionBD.java`).
- `src/main/java/com/sena/api/dto/` — Objetos de transferencia de datos (`UsuarioDTO`, `SolicitudDTO`, `RespuestaDTO`).
- `src/main/java/com/sena/api/filter/` — Filtro global de CORS (`CorsFilter.java`).
- `src/main/java/com/sena/api/servlet/` — Controladores REST (`AuthServlet`, `UsuarioServlet`, `SolicitudServlet`).
- `database.sql` — Script de creación de la base de datos y registros iniciales.

## Endpoints disponibles

Base local sugerida: `http://localhost:8080/api-sena`

| Método | Ruta | Descripción |
| :--- | :--- | :--- |
| `POST` | `/api/login` | Valida credenciales contra MySQL y retorna los datos del usuario. |
| `GET` | `/api/usuarios` | Lista los usuarios registrados. |
| `POST` | `/api/usuarios` | Registra un nuevo usuario (`nombre`, `email`, `password`, `rol`). |
| `DELETE` | `/api/usuarios?id={id}` | Elimina un usuario por su identificador. |
| `GET` | `/api/solicitudes` | Lista las solicitudes registradas. |
| `POST` | `/api/solicitudes` | Registra una nueva solicitud (`codigo`, `cliente`, `servicio`, `fecha`, `estado`). |
| `PUT` | `/api/solicitudes` | Actualiza el estado de una solicitud (`id`, `estado`). |
| `DELETE` | `/api/solicitudes?id={id}` | Elimina una solicitud por su identificador. |

## Puesta en marcha

1. Ejecutar `database.sql` en MySQL para crear la base de datos `app_integracion_sena`.
2. Verificar usuario y contraseña de MySQL en `ConexionBD.java`.
3. Compilar y empaquetar el proyecto desde la raíz:
   ```bash
   mvn clean package
