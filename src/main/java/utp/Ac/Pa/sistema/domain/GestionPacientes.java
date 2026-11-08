package utp.Ac.Pa.sistema.domain;

import java.util.ArrayList;
import java.util.List;

public class GestionPacientes {

    private List<Paciente> pacientes;

    public GestionPacientes() {
        pacientes = new ArrayList<>();
    }

    public void registrarPaciente(Paciente paciente) {

        if (paciente == null) {
            throw new IllegalArgumentException(
                "El paciente no puede ser nulo"
            );
        }

        // Evitar IDs repetidos
        if (buscarPorId(paciente.getId()) != null) {
            throw new IllegalArgumentException(
                "Ya existe un paciente con ese ID"
            );
        }

        // Evitar cédulas repetidas
        if (buscarPorCedula(paciente.getCedula()) != null) {
            throw new IllegalArgumentException(
                "Ya existe un paciente con esa cédula"
            );
        }

        pacientes.add(paciente);
    }

    public Paciente buscarPorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public Paciente buscarPorCedula(String cedula) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                return paciente;
            }
        }
        return null;
    }

    public List<Paciente> getPacientes() {
        return new ArrayList<>(pacientes);
    }

    public void mostrarPacientes() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }
}

