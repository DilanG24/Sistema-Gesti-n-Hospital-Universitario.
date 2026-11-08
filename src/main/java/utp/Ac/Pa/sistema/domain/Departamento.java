package utp.Ac.Pa.sistema.domain;

public class Departamento {

    private int id;
    private String nombre;
    private String descripcion;

    public Departamento(int id, String nombre, String descripcion) {

        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }

        this.id = id;
        setNombre(nombre);
        setDescripcion(descripcion);
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

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción es obligatoria");
        }
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre
                + " | ID: " + id
                + " | Descripción: " + descripcion;
    }
}