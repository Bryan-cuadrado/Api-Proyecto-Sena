CREATE DATABASE IF NOT EXISTS app_integracion_sena
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE app_integracion_sena;

CREATE TABLE IF NOT EXISTS usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(120) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  rol VARCHAR(30) NOT NULL DEFAULT 'USER'
);

CREATE TABLE IF NOT EXISTS solicitudes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  codigo VARCHAR(20) NOT NULL UNIQUE,
  cliente VARCHAR(100) NOT NULL,
  servicio VARCHAR(150) NOT NULL,
  fecha VARCHAR(30) NOT NULL,
  estado VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE'
);

INSERT IGNORE INTO usuarios (nombre, email, password, rol) VALUES
  ('Administrador', 'admin@admin.com', '123456', 'ADMIN'),
  ('Bryan De Jesús Cuadrado', 'bryan.cuadrado@sena.edu.co', '123456', 'QA_LEAD');

INSERT IGNORE INTO solicitudes (codigo, cliente, servicio, fecha, estado) VALUES
  ('SOL-001', 'Carlos Mendoza', 'Integración Pasarela de Pagos', '2026-11-20 10:00', 'APROBADA');
