package utp.Ac.Pa.sistema;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import utp.Ac.Pa.sistema.domain.Administrador;
import utp.Ac.Pa.sistema.domain.Cita;
import utp.Ac.Pa.sistema.domain.Departamento;
import utp.Ac.Pa.sistema.domain.Especialidad;
import utp.Ac.Pa.sistema.domain.Farmacia;
import utp.Ac.Pa.sistema.domain.Historial;
import utp.Ac.Pa.sistema.domain.Inventario;
import utp.Ac.Pa.sistema.domain.Medico;
import utp.Ac.Pa.sistema.domain.Medicamento;
import utp.Ac.Pa.sistema.domain.Paciente;
import utp.Ac.Pa.sistema.domain.Receta;
import utp.Ac.Pa.sistema.domain.Tratamiento;

public class App {

    public static void main(String[] args) {

        Especialidad medicinaGeneral = new Especialidad(1, "Medicina General", "Atencion medica general");
        Departamento salud = new Departamento(1, "Departamento de Salud", "Atencion medica para estudiantes y personal");
        Medico medico = new Medico(1, "Jafeth", "Guevara", medicinaGeneral, salud);
        Paciente paciente = new Paciente(1, "Jasson", "Samudio", "8-123-456");
        Cita cita = new Cita(1, paciente, medico, "01/12/2026", "04:00 AM");
        Tratamiento tratamiento = new Tratamiento(1, "Tratamiento para fiebre", "10 dias", paciente, medico);

        Historial historial = new Historial(1, paciente);
        historial.agregarCita(cita);
        historial.agregarTratamiento(tratamiento);

        Medicamento medicamento = new Medicamento(1, "Paracetamol", "Analgésico", 60);
        Receta receta = new Receta(1, paciente, medico);
        receta.agregarMedicamento(medicamento);

        Farmacia farmacia = new Farmacia(1, "Farmacia UTP", "Departamento de Salud");
        Inventario inventario = new Inventario(1, farmacia);
        farmacia.asignarInventario(inventario);
        inventario.agregarMedicamento(medicamento);

        Administrador administrador = new Administrador(1, "Luis", "Luis.admin", "Administrador");
        administrador.registrarAuditoria("Registro de paciente y cita");

        // ---- Panel de opciones ----
        SwingUtilities.invokeLater(() -> {
            String[] opciones = {"Paciente", "Médico", "Cita", "Tratamiento",
                                 "Medicamento", "Farmacia", "Salir"};
            while (true) {
                int sel = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione una opción",
                        "Sistema de Gestión Hospital Universitario",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null, opciones, opciones[0]);

                if (sel == -1 || sel == opciones.length - 1) {
                    break; // cerró la ventana o eligió Salir
                }

                String info;
                switch (sel) {
                    case 0: info = "Paciente: Jasson Samudio\nCédula: 8-123-456"; break;
                    case 1: info = "Médico: Jafeth Guevara\nEspecialidad: Medicina General"; break;
                    case 2: info = "Cita: 01/12/2026 a las 04:00 AM"; break;
                    case 3: info = "Tratamiento: fiebre\nDuración: 10 días"; break;
                    case 4: info = "Medicamento: Paracetamol\nStock: 60"; break;
                    case 5: info = "Farmacia UTP\nDepartamento de Salud"; break;
                    default: info = "";
                }
                JOptionPane.showMessageDialog(null, info, opciones[sel], JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}