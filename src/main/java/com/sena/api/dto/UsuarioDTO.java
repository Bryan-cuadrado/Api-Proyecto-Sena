package com.sena.api.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String email;
    private String rol;

    public UsuarioDTO(int id, String nombre, String email, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public String toJson() {
        return "{" +
               "\"id\": " + id + ", " +
               "\"nombre\": \"" + nombre + "\", " +
               "\"email\": \"" + email + "\", " +
               "\"rol\": \"" + rol + "\"" +
               "}";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
