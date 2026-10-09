package utp.Ac.Pa.sistema.domain;
public class Tratamiento {
    private int id;
    private String descripcion;
    private String duracion;
    private Paciente paciente;
    private Medico medico;

    public Tratamiento(int id, String descripcion, String duracion,
                       Paciente paciente, Medico medico) {

        this.id = id;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.paciente = paciente;
        this.medico = medico;

    }

    public int getId() {
        return id;

    }

    public String getDescripcion() {
        return descripcion;

    }

    public String getDuracion() {
        return duracion;

    }

    public Paciente getPaciente() {
        return paciente;

    }

    public Medico getMedico() {
        return medico;
        
    }
}