package utp.Ac.Pa.sistema.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Administrador {

    private int id;
    private String nombre;
    private String usuario;
    private String rol;
    private List<String> auditoria;

    public Administrador(int id, String nombre, String usuario, String rol) {

        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }

        this.id = id;
        setNombre(nombre);
        setUsuario(usuario);
        setRol(rol);
        this.auditoria = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getRol() {
        return rol;
    }

    public List<String> getAuditoria() {
        return Collections.unmodifiableList(auditoria);
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario es obligatorio");
        }
        this.usuario = usuario;
    }

    public void setRol(String rol) {
        if (rol == null || rol.trim().isEmpty()) {
            throw new IllegalArgumentException("El rol es obligatorio");
        }
        this.rol = rol;
    }

    public boolean validarRol(String rolRequerido) {
        return rolRequerido != null
                && this.rol.equalsIgnoreCase(rolRequerido);
    }

    public void registrarAuditoria(String accion) {
        if (accion == null || accion.trim().isEmpty()) {
            throw new IllegalArgumentException("La acción no puede estar vacía");
        }

        auditoria.add(accion);
    }

    @Override
    public String toString() {
        return "Administrador: " + nombre
                + " | ID: " + id
                + " | Usuario: " + usuario
                + " | Rol: " + rol
                + " | Acciones registradas: " + auditoria.size();
    }
}