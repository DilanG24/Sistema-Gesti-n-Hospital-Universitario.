
package utp.Ac.Pa.sistema.domain;

import java.util.ArrayList;
import java.util.List;

public class GestionMedicos {

    private List<Medico> medicos;

    public GestionMedicos() {
        medicos = new ArrayList<>();
    }

    // Registrar un médico
    public void registrarMedico(Medico medico) {

        if (medico == null) {
            throw new IllegalArgumentException(
                "El médico no puede ser nulo"
            );
        }

        if (buscarPorId(medico.getId()) != null) {
            throw new IllegalArgumentException(
                "Ya existe un médico con ese ID"
            );
        }

        medicos.add(medico);
    }

    // Buscar médico por ID
    public Medico buscarPorId(int id) {

        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }

        return null;
    }

    // Buscar médicos por especialidad
    public List<Medico> buscarPorEspecialidad(String nombreEspecialidad) {

        List<Medico> resultado = new ArrayList<>();

        if (nombreEspecialidad == null) {
            return resultado;
        }

        for (Medico medico : medicos) {
            if (medico.getEspecialidad().getNombre()
                    .equalsIgnoreCase(nombreEspecialidad.trim())) {
                resultado.add(medico);
            }
        }

        return resultado;
    }

    // Consultar todos los médicos
    public List<Medico> getMedicos() {
        return new ArrayList<>(medicos);
    }

    // Mostrar médicos
    public void mostrarMedicos() {

        if (medicos.isEmpty()) {
            System.out.println("No hay médicos registrados");
            return;
        }

        for (Medico medico : medicos) {
            System.out.println(medico);
        }
    }
}
