package utp.Ac.Pa.sistema.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventario {

    private int id;
    private Farmacia farmacia;
    private List<Medicamento> medicamentos;

    public Inventario(int id, Farmacia farmacia) {

        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }

        if (farmacia == null) {
            throw new IllegalArgumentException("La farmacia es obligatoria");
        }

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
        return Collections.unmodifiableList(medicamentos);
    }

    public void agregarMedicamento(Medicamento medicamento) {

        if (medicamento == null) {
            throw new IllegalArgumentException("El medicamento no puede ser nulo");
        }

        if (buscarMedicamento(medicamento.getId()) != null) {
            throw new IllegalArgumentException("El medicamento ya existe en el inventario");
        }

        medicamentos.add(medicamento);
    }

    public Medicamento buscarMedicamento(int id) {

        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getId() == id) {
                return medicamento;
            }
        }

        return null;
    }

    public boolean retirarMedicamento(int id, int cantidad) {

        Medicamento medicamento = buscarMedicamento(id);

        if (medicamento == null) {
            return false;
        }

        return medicamento.disminuirCantidad(cantidad);
    }

    public void mostrarMedicamentos() {

        if (medicamentos.isEmpty()) {
            System.out.println("El inventario está vacío");
            return;
        }

        for (Medicamento medicamento : medicamentos) {
            System.out.println(medicamento);
        }
    }

    @Override
    public String toString() {
        return "Inventario ID: " + id
                + " | Cantidad de medicamentos: " + medicamentos.size();
    }
}