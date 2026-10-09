package utp.Ac.Pa.sistema.domain;
import java.util.ArrayList;
import java.util.List;

public class Receta {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private List<Medicamento> medicamentos;

    public Receta(int id, Paciente paciente, Medico medico) {
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
        return medicamentos;

    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
        
    }
}