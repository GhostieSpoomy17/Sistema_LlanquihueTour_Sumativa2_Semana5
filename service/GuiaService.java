package service;

import model.Guia;
import java.util.ArrayList;

public class GuiaService {

    private ArrayList<Guia> guias;

    public GuiaService(ArrayList<Guia> guias) {
        this.guias = guias;
    }

    public void mostrarTodos() {
        if (guias.isEmpty()) {
            System.out.println("No hay guías registrados.");
            return;
        }
        for (Guia g : guias) {
            System.out.println(g);
            System.out.println("------------------------");
        }
    }

    public Guia buscarPorRut(String rut) {
        for (Guia g : guias) {
            if (g.getRut().equalsIgnoreCase(rut)) {
                return g;
            }
        }
        return null;
    }

    public ArrayList<Guia> buscarPorEspecialidad(String especialidad) {
        ArrayList<Guia> resultado = new ArrayList<>();
        for (Guia g : guias) {
            if (g.getEspecialidad().equalsIgnoreCase(especialidad)) {
                resultado.add(g);
            }
        }
        return resultado;
    }

    public ArrayList<Guia> buscarExperimentados() {
        ArrayList<Guia> resultado = new ArrayList<>();
        for (Guia g : guias) {
            if (g.esExperimentado()) {
                resultado.add(g);
            }
        }
        return resultado;
    }
}