
package utp.Ac.Pa.sistema.domain;

public class Medico {

    private int id;
    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private Departamento departamento;

    public Medico(int id, String nombre, String apellido,
                  Especialidad especialidad, Departamento departamento) {

        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }

        this.id = id;
        setNombre(nombre);
        setApellido(apellido);
        setEspecialidad(especialidad);
        setDepartamento(departamento);
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Departamento getDepartamento() {
        return departamento;
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

    public void setEspecialidad(Especialidad especialidad) {
        if (especialidad == null) {
            throw new IllegalArgumentException("La especialidad es obligatoria");
        }
        this.especialidad = especialidad;
    }

    public void setDepartamento(Departamento departamento) {
        if (departamento == null) {
            throw new IllegalArgumentException("El departamento es obligatorio");
        }
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Medico: " + nombre + " " + apellido
                + " | ID: " + id
                + " | Especialidad: " + especialidad
                + " | Departamento: " + departamento;
    }
}
