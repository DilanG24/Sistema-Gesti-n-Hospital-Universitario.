package utp.Ac.Pa.sistema.domain;

public class Farmacia {

    private int id;
    private String nombre;
    private String ubicacion;
    private Inventario inventario;

    public Farmacia(int id, String nombre, String ubicacion) {

        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }

        this.id = id;
        setNombre(nombre);
        setUbicacion(ubicacion);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        if (ubicacion == null || ubicacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La ubicación es obligatoria");
        }
        this.ubicacion = ubicacion;
    }

    public void asignarInventario(Inventario inventario) {
        if (inventario == null) {
            throw new IllegalArgumentException("El inventario no puede ser nulo");
        }

        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Farmacia: " + nombre
                + " | ID: " + id
                + " | Ubicación: " + ubicacion;
    }
}