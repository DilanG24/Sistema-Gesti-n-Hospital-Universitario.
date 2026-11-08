
package utp.Ac.Pa.sistema.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Historial {

    private int id;
    private Paciente paciente;
    private List<Cita> citas;
    private List<Tratamiento> tratamientos;

    public Historial(int id, Paciente paciente) {

        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }

        if (paciente == null) {
            throw new IllegalArgumentException("El paciente es obligatorio");
        }

        this.id = id;
        this.paciente = paciente;
        this.citas = new ArrayList<>();
        this.tratamientos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }

    public List<Tratamiento> getTratamientos() {
        return Collections.unmodifiableList(tratamientos);
    }

    public void agregarCita(Cita cita) {
        if (cita == null) {
            throw new IllegalArgumentException("La cita no puede ser nula");
        }

        if (!citas.contains(cita)) {
            citas.add(cita);
        }
    }

    public void agregarTratamiento(Tratamiento tratamiento) {
        if (tratamiento == null) {
            throw new IllegalArgumentException("El tratamiento no puede ser nulo");
        }

        if (!tratamientos.contains(tratamiento)) {
            tratamientos.add(tratamiento);
        }
    }

    @Override
    public String toString() {
        return "Historial ID: " + id
                + " | Paciente: " + paciente.getNombre() + " " + paciente.getApellido()
                + " | Cantidad de citas: " + citas.size()
                + " | Cantidad de tratamientos: " + tratamientos.size();
    }
}
