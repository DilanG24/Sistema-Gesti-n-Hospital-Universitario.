

package utp.Ac.Pa.sistema.domain;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeParseException;

public class GestionCitas {

    private List<Cita> citas;

    public GestionCitas() {
        citas = new ArrayList<>();
    }

    // Registrar una cita
    public void registrarCita(Cita cita) {

        if (cita == null) {
            throw new IllegalArgumentException(
                    "La cita no puede ser nula");
        }

        if (buscarPorId(cita.getId()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe una cita con ese ID");
        }

        for (Cita existente : citas) {

            boolean mismoMedico =
                    existente.getMedico().getId()
                    == cita.getMedico().getId();

            if (mismoMedico && existente.esMismaFechaHora(cita)) {
                throw new IllegalArgumentException(
                        "El médico ya tiene una cita en esa fecha y hora");
            }
        }

        citas.add(cita);
    }

    // Obtener horarios disponibles de un médico
    public List<String> obtenerHorariosDisponibles(
            int medicoId, String fecha) {

        LocalDate fechaSeleccionada;

        try {
            fechaSeleccionada = LocalDate.parse(fecha);
        } catch (DateTimeParseException | NullPointerException e) {
            throw new IllegalArgumentException(
                    "La fecha debe tener el formato AAAA-MM-DD");
        }

        if (fechaSeleccionada.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "No se pueden reservar fechas anteriores");
        }

        DayOfWeek dia = fechaSeleccionada.getDayOfWeek();

        if (dia == DayOfWeek.SATURDAY
                || dia == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException(
                    "El hospital atiende solamente de lunes a viernes");
        }

        // Horario de atención: 8:00 AM a 4:00 PM
        String[] horarios = {
            "08:00",
            "09:00",
            "10:00",
            "11:00",
            "12:00",
            "13:00",
            "14:00",
            "15:00"
        };

        List<String> disponibles = new ArrayList<>();

        for (String hora : horarios) {

            boolean ocupado = false;

            for (Cita cita : citas) {

                if (cita.getMedico().getId() == medicoId
                        && cita.getFecha().equals(fecha)
                        && cita.getHora().equals(hora)) {

                    ocupado = true;
                    break;
                }
            }

            if (!ocupado) {
                disponibles.add(hora);
            }
        }

        return disponibles;
    }

    // Buscar cita por ID
    public Cita buscarPorId(int id) {
        for (Cita cita : citas) {
            if (cita.getId() == id) {
                return cita;
            }
        }
        return null;
    }

    // Buscar citas de un paciente
    public List<Cita> buscarPorPaciente(int pacienteId) {
        List<Cita> resultado = new ArrayList<>();

        for (Cita cita : citas) {
            if (cita.getPaciente().getId() == pacienteId) {
                resultado.add(cita);
            }
        }

        return resultado;
    }

    // Buscar citas de un médico
    public List<Cita> buscarPorMedico(int medicoId) {
        List<Cita> resultado = new ArrayList<>();

        for (Cita cita : citas) {
            if (cita.getMedico().getId() == medicoId) {
                resultado.add(cita);
            }
        }

        return resultado;
    }

    // Consultar todas las citas
    public List<Cita> getCitas() {
        return new ArrayList<>(citas);
    }

    // Mostrar todas las citas
    public void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas");
            return;
        }

        for (Cita cita : citas) {
            System.out.println(cita);
        }
    }
}
