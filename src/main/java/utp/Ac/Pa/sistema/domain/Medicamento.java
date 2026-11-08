package utp.Ac.Pa.sistema.domain;

public class Medicamento {

    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;

    public Medicamento(int id, String nombre, String descripcion, int cantidad) {

        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }

        this.id = id;
        setNombre(nombre);
        setDescripcion(descripcion);

        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }

        this.cantidad = cantidad;
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

    public int getCantidad() {
        return cantidad;
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

    public void aumentarCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }

        this.cantidad += cantidad;
    }

    public boolean disminuirCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }

        if (cantidad <= this.cantidad) {
            this.cantidad -= cantidad;
            return true;
        }

        return false;
    }

    public boolean hayExistencias() {
        return cantidad > 0;
    }

    @Override
    public String toString() {
        return "Medicamento: " + nombre
                + " | ID: " + id
                + " | Descripción: " + descripcion
                + " | Existencias: " + cantidad;
    }
}