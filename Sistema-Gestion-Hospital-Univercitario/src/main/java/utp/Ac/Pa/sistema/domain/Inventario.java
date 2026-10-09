package utp.Ac.Pa.sistema.domain;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private int id;
    private Farmacia farmacia;
    private List<Medicamento> medicamentos;

    public Inventario(int id, Farmacia farmacia) {
        this.id = id;
        this.farmacia = farmacia;
        this.medicamentos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public boolean retirarMedicamento(Medicamento medicamento, int cantidad) {
        return medicamento.disminuirCantidad(cantidad);
    }
}