package utp.Ac.Pa.sistema.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Receta {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private List<Medicamento> medicamentos;

    public Receta(int id, Paciente paciente, Medico medico) {

        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }

        if (paciente == null) {
            throw new IllegalArgumentException("El paciente es obligatorio");
        }

        if (medico == null) {
            throw new IllegalArgumentException("El médico es obligatorio");
        }

        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.medicamentos = new ArrayList<>();
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

    public List<Medicamento> getMedicamentos() {
        return Collections.unmodifiableList(medicamentos);
    }

    public void agregarMedicamento(Medicamento medicamento) {

        if (medicamento == null) {
            throw new IllegalArgumentException("El medicamento no puede ser nulo");
        }

        if (!medicamentos.contains(medicamento)) {
            medicamentos.add(medicamento);
        }
    }

    public void eliminarMedicamento(Medicamento medicamento) {
        medicamentos.remove(medicamento);
    }

    @Override
    public String toString() {
        return "Receta ID: " + id
                + " | Paciente: " + paciente.getNombre()
                + " " + paciente.getApellido()
                + " | Médico: " + medico.getNombre()
                + " " + medico.getApellido()
                + " | Cantidad de medicamentos: " + medicamentos.size();
    }
}