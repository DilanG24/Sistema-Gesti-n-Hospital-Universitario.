package utp.Ac.Pa.sistema.domain;

public class Cita {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private String fecha;
    private String hora;

    public Cita(int id, Paciente paciente, Medico medico,
                String fecha, String hora) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public boolean esMismaFechaHora(Cita otraCita) {
        return this.fecha.equals(otraCita.fecha)
                && this.hora.equals(otraCita.hora);
    }
}