package com.sena.api.servlet;

import com.sena.api.dto.UsuarioDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/api/usuarios"})
public class UsuarioServlet extends HttpServlet {

    private static List<UsuarioDTO> baseDatosUsuarios = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        baseDatosUsuarios.add(new UsuarioDTO(1, "Administrador", "admin@admin.com", "ADMIN"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        configurarCabeceras(response);
        
        StringBuilder jsonResponse = new StringBuilder("[");
        for (int i = 0; i < baseDatosUsuarios.size(); i++) {
            jsonResponse.append(baseDatosUsuarios.get(i).toJson());
            if (i < baseDatosUsuarios.size() - 1) jsonResponse.append(",");
        }
        jsonResponse.append("]");

        enviarRespuesta(response, HttpServletResponse.SC_OK, jsonResponse.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        configurarCabeceras(response);
        
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String rol = request.getParameter("rol");

        if (nombre == null || email == null) {
            enviarRespuesta(response, HttpServletResponse.SC_BAD_REQUEST, "{\"error\": \"Faltan datos requeridos\"}");
            return;
        }

        int nuevoId = baseDatosUsuarios.size() + 1;
        UsuarioDTO nuevoUsuario = new UsuarioDTO(nuevoId, nombre, email, rol != null ? rol : "USER");
        baseDatosUsuarios.add(nuevoUsuario);

        enviarRespuesta(response, HttpServletResponse.SC_CREATED, "{\"mensaje\": \"Usuario creado exitosamente\", \"id\": " + nuevoId + "}");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        configurarCabeceras(response);
        
        String idParam = request.getParameter("id");
        if (idParam == null) {
            enviarRespuesta(response, HttpServletResponse.SC_BAD_REQUEST, "{\"error\": \"ID requerido para eliminar\"}");
            return;
        }

        int id = Integer.parseInt(idParam);
        boolean eliminado = baseDatosUsuarios.removeIf(u -> u.getId() == id);

        if (eliminado) {
            enviarRespuesta(response, HttpServletResponse.SC_OK, "{\"mensaje\": \"Usuario eliminado correctamente\"}");
        } else {
            enviarRespuesta(response, HttpServletResponse.SC_NOT_FOUND, "{\"error\": \"Usuario no encontrado\"}");
        }
    }

    private void configurarCabeceras(HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
    }

    private void enviarRespuesta(HttpServletResponse response, int status, String cuerpo) throws IOException {
        response.setStatus(status);
        try (PrintWriter out = response.getWriter()) {
            out.print(cuerpo);
            out.flush();
        }
    }
}
