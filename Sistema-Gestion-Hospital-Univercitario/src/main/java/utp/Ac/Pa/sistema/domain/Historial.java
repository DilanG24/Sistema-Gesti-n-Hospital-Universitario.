package utp.Ac.Pa.sistema.domain;

import java.util.ArrayList;
import java.util.List;

public class Historial {

    private int id;
    private Paciente paciente;
    private List<Cita> citas;
    private List<Tratamiento> tratamientos;

    public Historial(int id, Paciente paciente) {
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
        return citas;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public void agregarTratamiento(Tratamiento tratamiento) {
        tratamientos.add(tratamiento);
    }
}