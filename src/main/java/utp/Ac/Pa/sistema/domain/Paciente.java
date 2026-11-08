 
package utp.Ac.Pa.sistema.domain;

public class Paciente {

    private int id;
    private String nombre;
    private String apellido;
    private String cedula;

    public Paciente(int id, String nombre, String apellido, String cedula) {
        this.id = id;
        setNombre(nombre);
        setApellido(apellido);
        setCedula(cedula);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cedula es obligatoria");
        }
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Paciente: " + nombre + " " + apellido
                + " | ID: " + id
                + " | Cedula: " + cedula;
    }
}
