
package utp.Ac.Pa.sistema;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.util.List;

import utp.Ac.Pa.sistema.domain.Administrador;
import utp.Ac.Pa.sistema.domain.Cita;
import utp.Ac.Pa.sistema.domain.Departamento;
import utp.Ac.Pa.sistema.domain.Especialidad;
import utp.Ac.Pa.sistema.domain.Farmacia;
import utp.Ac.Pa.sistema.domain.GestionPacientes;
import utp.Ac.Pa.sistema.domain.GestionMedicos;
import utp.Ac.Pa.sistema.domain.GestionCitas;
import utp.Ac.Pa.sistema.domain.Inventario;
import utp.Ac.Pa.sistema.domain.Medico;
import utp.Ac.Pa.sistema.domain.Medicamento;
import utp.Ac.Pa.sistema.domain.Paciente;

public class App {

    public static void main(String[] args) {

        // Departamento
        Departamento salud = new Departamento(
                1, "Departamento de Salud",
                "Atencion medica para estudiantes y personal");

        // Especialidades
        Especialidad general = new Especialidad(
                1, "Medicina General", "Atencion general");

        Especialidad pediatria = new Especialidad(
                2, "Pediatria", "Atencion infantil");

        Especialidad cardiologia = new Especialidad(
                3, "Cardiologia", "Atencion del corazon");

        Especialidad dermatologia = new Especialidad(
                4, "Dermatologia", "Atencion de la piel");

        Especialidad odontologia = new Especialidad(
                5, "Odontologia", "Atencion dental");

        // Medicos registrados inicialmente
        Medico medico1 = new Medico(
                1, "Jafeth", "Guevara", general, salud);

        Medico medico2 = new Medico(
                2, "Willie", "Rex", pediatria, salud);

        Medico medico3 = new Medico(
                3, "Charlie", "Kirk", cardiologia, salud);

        Medico medico4 = new Medico(
                4, "Kanye", "West", dermatologia, salud);

        Medico medico5 = new Medico(
                5, "Mister", "Beast", odontologia, salud);

        // Clases de gestion
        GestionPacientes gestionPacientes = new GestionPacientes();
        GestionMedicos gestionMedicos = new GestionMedicos();
        GestionCitas gestionCitas = new GestionCitas();

        // Registrar medicos
        gestionMedicos.registrarMedico(medico1);
        gestionMedicos.registrarMedico(medico2);
        gestionMedicos.registrarMedico(medico3);
        gestionMedicos.registrarMedico(medico4);
        gestionMedicos.registrarMedico(medico5);

        // Farmacia e inventario
        Medicamento medicamento = new Medicamento(
                1, "Paracetamol", "Analgesico", 60);

        Farmacia farmacia = new Farmacia(1, "Farmacia UTP", "Departamento de Salud");

Inventario inventario = new Inventario(1, farmacia);

farmacia.asignarInventario(inventario);

// Medicamentos del inventario
Medicamento medicamento1 = new Medicamento(1, "Paracetamol", "Analgesico", 60);
Medicamento medicamento2 = new Medicamento(2, "Ibuprofeno", "Antiinflamatorio", 40);
Medicamento medicamento3 = new Medicamento(3, "Loratadina", "Antihistaminico", 30);
Medicamento medicamento4 = new Medicamento(4, "Omeprazol", "Protector gastrico", 25);
Medicamento medicamento5 = new Medicamento(5, "Amoxicilina", "Antibiotico", 35);
Medicamento medicamento6 = new Medicamento(6, "Suero oral", "Solucion de rehidratacion", 50);
Medicamento medicamento7 = new Medicamento(7, "Vitamina C", "Suplemento vitaminico", 40);

// Agregar medicamentos al inventario
inventario.agregarMedicamento(medicamento1);
inventario.agregarMedicamento(medicamento2);
inventario.agregarMedicamento(medicamento3);
inventario.agregarMedicamento(medicamento4);
inventario.agregarMedicamento(medicamento5);
inventario.agregarMedicamento(medicamento6);
inventario.agregarMedicamento(medicamento7);

        // Administrador
        Administrador administrador = new Administrador(
                1, "Luis", "Luis.admin", "Administrador");

        administrador.registrarAuditoria(
                "Inicio del sistema hospitalario");

        // Panel principal
        SwingUtilities.invokeLater(() -> {

            String[] opciones = {
                "Paciente",
                "Médico",
                "Cita",
                "Medicamento",
                "Farmacia",
                "Salir"
            };

            while (true) {

                int seleccion = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione una opción",
                        "Sistema de Gestión Hospital Universitario",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);

                if (seleccion == -1 || seleccion == 5) {
                    break;
                }

                switch (seleccion) {

                    case 0:
                        menuPacientes(
                                gestionPacientes, administrador);
                        break;

                    case 1:
                        mostrarMedicos(gestionMedicos);
                        break;

                    case 2:
                        menuCitas(
                                gestionCitas,
                                gestionPacientes,
                                gestionMedicos,
                                administrador);
                        break;

                    case 3:
    StringBuilder listaMedicamentos = new StringBuilder();

    listaMedicamentos.append("INVENTARIO DE FARMACIA\n\n");

    listaMedicamentos.append(medicamento1).append("\n");
    listaMedicamentos.append(medicamento2).append("\n");
    listaMedicamentos.append(medicamento3).append("\n");
    listaMedicamentos.append(medicamento4).append("\n");
    listaMedicamentos.append(medicamento5).append("\n");
    listaMedicamentos.append(medicamento6).append("\n");
    listaMedicamentos.append(medicamento7).append("\n");

    JOptionPane.showMessageDialog(null, listaMedicamentos.toString());
    break;

                    case 4:
                        JOptionPane.showMessageDialog(
                                null, farmacia);
                        break;
                }
            }
        });
    }

    // Gestion de pacientes
    public static void menuPacientes(
            GestionPacientes gestion,
            Administrador administrador) {

        String[] opciones = {
            "Registrar paciente",
            "Consultar pacientes",
            "Volver"
        };

        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción",
                "Gestión de pacientes",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (seleccion == 0) {

            try {

                Integer id = pedirEntero(
                        "Ingrese el ID del paciente:");

                if (id == null) return;

                String nombre = JOptionPane.showInputDialog(
                        "Ingrese el nombre:");

                if (nombre == null) return;

                String apellido = JOptionPane.showInputDialog(
                        "Ingrese el apellido:");

                if (apellido == null) return;

                String cedula = JOptionPane.showInputDialog(
                        "Ingrese la cédula:");

                if (cedula == null) return;

                Paciente nuevoPaciente = new Paciente(
                        id, nombre, apellido, cedula);

                gestion.registrarPaciente(nuevoPaciente);

                administrador.registrarAuditoria(
                        "Registro de paciente: " + nombre);

                JOptionPane.showMessageDialog(
                        null,
                        "Paciente registrado correctamente.");

            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else if (seleccion == 1) {

            List<Paciente> pacientes = gestion.getPacientes();

            if (pacientes.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "No hay pacientes registrados.");
                return;
            }

            StringBuilder informacion = new StringBuilder();

            for (Paciente p : pacientes) {
                informacion.append(p).append("\n\n");
            }

            JOptionPane.showMessageDialog(
                    null,
                    informacion.toString(),
                    "Pacientes registrados",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Consultar medicos
    public static void mostrarMedicos(GestionMedicos gestion) {

        List<Medico> medicos = gestion.getMedicos();

        if (medicos.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, "No hay médicos registrados.");
            return;
        }

        StringBuilder informacion = new StringBuilder();

        for (Medico medico : medicos) {
            informacion.append(medico).append("\n\n");
        }

        JOptionPane.showMessageDialog(
                null,
                informacion.toString(),
                "Médicos registrados",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Gestion de citas
    public static void menuCitas(
            GestionCitas gestion,
            GestionPacientes pacientes,
            GestionMedicos medicos,
            Administrador administrador) {

        String[] opciones = {
            "Crear cita",
            "Consultar citas",
            "Volver"
        };

        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción",
                "Gestión de citas",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (seleccion == 0) {

            try {

                // Seleccionar paciente
                List<Paciente> listaPacientes =
                        pacientes.getPacientes();

                if (listaPacientes.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Primero debe registrar un paciente.");
                    return;
                }

                Paciente[] opcionesPacientes =
                        listaPacientes.toArray(new Paciente[0]);

                Paciente paciente =
                        (Paciente) JOptionPane.showInputDialog(
                                null,
                                "Seleccione el paciente:",
                                "Pacientes registrados",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesPacientes,
                                opcionesPacientes[0]);

                if (paciente == null) return;

                // Seleccionar motivo
                String[] motivos = {
                    "Consulta general",
                    "Consulta infantil",
                    "Problema del corazón",
                    "Problema de la piel",
                    "Problema dental"
                };

                String motivo =
                        (String) JOptionPane.showInputDialog(
                                null,
                                "Seleccione el motivo de consulta:",
                                "Motivo de consulta",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                motivos,
                                motivos[0]);

                if (motivo == null) return;

                String especialidad = "";

                switch (motivo) {

                    case "Consulta general":
                        especialidad = "Medicina General";
                        break;

                    case "Consulta infantil":
                        especialidad = "Pediatria";
                        break;

                    case "Problema del corazón":
                        especialidad = "Cardiologia";
                        break;

                    case "Problema de la piel":
                        especialidad = "Dermatologia";
                        break;

                    case "Problema dental":
                        especialidad = "Odontologia";
                        break;
                }

                // Buscar medicos de la especialidad
                List<Medico> disponibles =
                        medicos.buscarPorEspecialidad(especialidad);

                if (disponibles.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "No hay médicos disponibles.");
                    return;
                }

                Medico[] opcionesMedicos =
                        disponibles.toArray(new Medico[0]);

                Medico medicoSeleccionado =
                        (Medico) JOptionPane.showInputDialog(
                                null,
                                "Seleccione el médico:",
                                "Médicos disponibles",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesMedicos,
                                opcionesMedicos[0]);

                if (medicoSeleccionado == null) return;

                // Solicitar fecha
                String fecha = JOptionPane.showInputDialog(
                        "Ingrese la fecha (AAAA-MM-DD):");

                if (fecha == null) return;

                // Obtener horarios disponibles
                List<String> horariosDisponibles =
                        gestion.obtenerHorariosDisponibles(
                                medicoSeleccionado.getId(), fecha);

                if (horariosDisponibles.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Este médico no tiene horarios disponibles.");
                    return;
                }

                // Mostrar horarios disponibles
                String[] opcionesHorarios =
                        horariosDisponibles.toArray(new String[0]);

                String horaSeleccionada =
                        (String) JOptionPane.showInputDialog(
                                null,
                                "Seleccione un horario disponible:",
                                "Horarios del médico",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesHorarios,
                                opcionesHorarios[0]);

                if (horaSeleccionada == null) return;

                // ID de la cita
                Integer id = pedirEntero(
                        "Ingrese el ID de la cita:");

                if (id == null) return;

                // Crear cita
                Cita nuevaCita = new Cita(
                        id,
                        paciente,
                        medicoSeleccionado,
                        fecha,
                        horaSeleccionada);

                gestion.registrarCita(nuevaCita);

                administrador.registrarAuditoria(
                        "Registro de cita ID: " + id);

                JOptionPane.showMessageDialog(
                        null,
                        "Cita registrada correctamente.\n\n"
                        + "Paciente: " + paciente.getNombre()
                        + " " + paciente.getApellido()
                        + "\nMédico: "
                        + medicoSeleccionado.getNombre()
                        + " " + medicoSeleccionado.getApellido()
                        + "\nFecha: " + fecha
                        + "\nHora: " + horaSeleccionada);

            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else if (seleccion == 1) {

            List<Cita> citas = gestion.getCitas();

            if (citas.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "No hay citas registradas.");
                return;
            }

            StringBuilder informacion = new StringBuilder();

            for (Cita cita : citas) {
                informacion.append(cita).append("\n\n");
            }

            JOptionPane.showMessageDialog(
                    null,
                    informacion.toString(),
                    "Citas registradas",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Solicitar numeros enteros
    public static Integer pedirEntero(String mensaje) {

        String entrada = JOptionPane.showInputDialog(mensaje);

        if (entrada == null) {
            return null;
        }

        try {

            return Integer.parseInt(entrada.trim());

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debe ingresar un número válido.");

            return null;
        }
    }
}
