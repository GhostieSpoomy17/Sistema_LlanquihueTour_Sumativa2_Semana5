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

    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }

    public void mostrarTodos() {
        if (entidades.isEmpty()) {
            System.out.println("No hay entidades registradas.");
            return;
        }
        for (Registrable r : entidades) {
            r.mostrarResumen();
            System.out.println("------------------------");
        }
    }

    public void mostrarPorTipo() {
        for (Registrable r : entidades) {
            if (r instanceof Guia) {
                System.out.println("[GUÍA] " + ((Guia) r).getNombre() + " " + ((Guia) r).getApellido());
            } else if (r instanceof ColaboradorExterno) {
                System.out.println("[COLABORADOR] " + ((ColaboradorExterno) r).getNombre() + " " + ((ColaboradorExterno) r).getApellido());
            } else if (r instanceof Vehiculo) {
                System.out.println("[VEHÍCULO] " + ((Vehiculo) r).getMarca() + " - " + ((Vehiculo) r).getPatente());
            }
        }
    }
}