package utp.Ac.Pa.sistema.domain;
public class Medico {
    private int id;
    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private Departamento departamento;

    public Medico(int id, String nombre, String apellido,
                  Especialidad especialidad, Departamento departamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.departamento = departamento;

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
}