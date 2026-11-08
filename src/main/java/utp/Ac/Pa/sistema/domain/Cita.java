
package utp.Ac.Pa.sistema.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Cita {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private String fecha;
    private String hora;

    public Cita(int id, Paciente paciente, Medico medico,
                String fecha, String hora) {

        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }

        if (paciente == null) {
            throw new IllegalArgumentException("El paciente es obligatorio");
        }

        if (medico == null) {
            throw new IllegalArgumentException("El medico es obligatorio");
        }

        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        setFecha(fecha);
        setHora(hora);
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

    public void setFecha(String fecha) {
        try {
            LocalDate.parse(fecha);
            this.fecha = fecha;
        } catch (DateTimeParseException | NullPointerException e) {
            throw new IllegalArgumentException(
                "La fecha debe tener el formato AAAA-MM-DD"
            );
        }
    }

    public void setHora(String hora) {
        try {
            LocalTime.parse(hora);
            this.hora = hora;
        } catch (DateTimeParseException | NullPointerException e) {
            throw new IllegalArgumentException(
                "La hora debe tener el formato HH:MM"
            );
        }
    }

    public boolean esMismaFechaHora(Cita otraCita) {
        return otraCita != null
                && this.fecha.equals(otraCita.fecha)
                && this.hora.equals(otraCita.hora);
    }

    @Override
    public String toString() {
        return "Cita ID: " + id
                + " | Paciente: " + paciente.getNombre()
                + " " + paciente.getApellido()
                + " | Medico: " + medico.getNombre()
                + " " + medico.getApellido()
                + " | Fecha: " + fecha
                + " | Hora: " + hora;
    }
}
