package utp.Ac.Pa.sistema.domain;

public class Tratamiento {

    private int id;
    private String descripcion;
    private String duracion;
    private Paciente paciente;
    private Medico medico;

    public Tratamiento(int id, String descripcion, String duracion,
                       Paciente paciente, Medico medico) {

        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }

        this.id = id;
        setDescripcion(descripcion);
        setDuracion(duracion);

        if (paciente == null) {
            throw new IllegalArgumentException("El paciente es obligatorio");
        }

        if (medico == null) {
            throw new IllegalArgumentException("El médico es obligatorio");
        }

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

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción es obligatoria");
        }
        this.descripcion = descripcion;
    }

    public void setDuracion(String duracion) {
        if (duracion == null || duracion.trim().isEmpty()) {
            throw new IllegalArgumentException("La duración es obligatoria");
        }
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Tratamiento ID: " + id
                + " | Descripción: " + descripcion
                + " | Duración: " + duracion
                + " | Paciente: " + paciente.getNombre()
                + " " + paciente.getApellido()
                + " | Médico: " + medico.getNombre()
                + " " + medico.getApellido();
    }
}