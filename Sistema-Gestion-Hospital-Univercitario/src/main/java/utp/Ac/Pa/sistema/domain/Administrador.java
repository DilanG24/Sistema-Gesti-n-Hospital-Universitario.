package utp.Ac.Pa.sistema.domain;

import java.util.ArrayList;
import java.util.List;

public class Administrador {

    private int id;
    private String nombre;
    private String usuario;
    private String rol;
    private List<String> auditoria;

    public Administrador(int id, String nombre, String usuario, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.rol = rol;
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
        return auditoria;
    }

    public boolean validarRol(String rolRequerido) {
        return this.rol.equalsIgnoreCase(rolRequerido);
    }

    public void registrarAuditoria(String accion) {
        auditoria.add(accion);
    }
}