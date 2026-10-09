package utp.Ac.Pa.sistema.domain;
public class Medicamento {
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;

    public Medicamento(int id, String nombre, String descripcion, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public void aumentarCantidad(int cantidad) {
        this.cantidad += cantidad;

    }

    public boolean disminuirCantidad(int cantidad) {
        if (cantidad <= this.cantidad) {
            this.cantidad -= cantidad;
            return true;

        }

        return false;
        
    }
}