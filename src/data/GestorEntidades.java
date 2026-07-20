package data;

import model.ColaboradorExterno;
import model.Guia;
import model.Registrable;
import model.Vehiculo;

import java.util.ArrayList;

public class GestorEntidades {

    private ArrayList<Registrable> entidades = new ArrayList<>();

    public void agregar(Registrable entidad) {
        entidades.add(entidad);
    }

    public int cantidadEntidades() {
        return entidades.size();
    }

    public boolean estaVacio() {
        return entidades.isEmpty();
    }

    public String construirResumenTodos() {
        if (entidades.isEmpty()) {
            return "No hay entidades registradas.";
        }
        StringBuilder sb = new StringBuilder();
        for (Registrable r : entidades) {
            sb.append(r.toString()).append("\n------------------------\n");
        }
        return sb.toString();
    }

    public String construirResumenPorTipo() {
        if (entidades.isEmpty()) {
            return "No hay entidades registradas.";
        }
        StringBuilder sb = new StringBuilder();
        for (Registrable r : entidades) {
            if (r instanceof Guia g) {
                sb.append("[GUÍA] ")
                        .append(g.getNombre()).append(" ").append(g.getApellido()).append("\n");
            } else if (r instanceof ColaboradorExterno c) {
                sb.append("[COLABORADOR] ")
                        .append(c.getNombre()).append(" ").append(c.getApellido()).append("\n");
            } else if (r instanceof Vehiculo v) {
                sb.append("[VEHÍCULO] ")
                        .append(v.getMarca()).append(" - ").append(v.getPatente()).append("\n");
            }
        }
        return sb.toString();
    }
}
