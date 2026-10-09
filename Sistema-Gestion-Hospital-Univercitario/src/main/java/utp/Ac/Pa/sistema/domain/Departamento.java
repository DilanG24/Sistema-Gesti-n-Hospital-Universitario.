package utp.Ac.Pa.sistema.domain;

public class Departamento {

    private int id;
    private String nombre;
    private String descripcion;

    public Departamento(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}