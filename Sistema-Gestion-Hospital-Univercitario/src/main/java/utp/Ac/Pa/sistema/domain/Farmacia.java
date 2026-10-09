package utp.Ac.Pa.sistema.domain;

public class Farmacia {

    private int id;
    private String nombre;
    private String ubicacion;
    private Inventario inventario;

    public Farmacia(int id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
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

    public void asignarInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}