# Documentación de Servicios Web (API REST) - Módulo de Usuarios

| Método HTTP | Endpoint | Descripción | Parámetros Requeridos | Códigos de Respuesta |
| :--- | :--- | :--- | :--- | :--- |
| **GET** | `/api/usuarios` | Obtiene el listado completo de todos los usuarios registrados en el sistema. | Ninguno | `200 OK`: Lista JSON de usuarios |
| **POST** | `/api/usuarios` | Crea un nuevo usuario en el sistema. | `nombre` (String), `email` (String), `rol` (String, opcional) | `201 Created`: Éxito al crear<br>`400 Bad Request`: Faltan datos |
| **DELETE** | `/api/usuarios` | Elimina un usuario específico utilizando su identificador único. | `id` (Integer) | `200 OK`: Éxito al eliminar<br>`400 Bad Request`: Sin ID<br>`404 Not Found`: ID no existe |
