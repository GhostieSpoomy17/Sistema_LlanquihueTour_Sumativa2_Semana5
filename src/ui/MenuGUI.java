package ui;

import data.GestorEntidades;
import model.ColaboradorExterno;
import model.Direccion;
import model.Guia;
import model.Vehiculo;

import javax.swing.JOptionPane;

public class MenuGUI {

    private GestorEntidades gestor;

    public MenuGUI(GestorEntidades gestor) {
        this.gestor = gestor;
    }

    public void iniciar() {
        String[] opciones = {
                "Agregar Guía",
                "Agregar Vehículo",
                "Agregar Colaborador Externo",
                "Mostrar todos",
                "Mostrar por tipo",
                "Salir"
        };

        boolean continuar = true;

        while (continuar) {
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Sistema Llanquihue Tour\n¿Qué deseas hacer?",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0 -> agregarGuia();
                case 1 -> agregarVehiculo();
                case 2 -> agregarColaborador();
                case 3 -> mostrarTodos();
                case 4 -> mostrarPorTipo();
                case 5, -1 -> continuar = false;
            }
        }

        JOptionPane.showMessageDialog(null, "Sistema cerrado. ¡Nos vemos!");
    }

    private void agregarGuia() {
        String nombre = JOptionPane.showInputDialog("Nombre del guía:");
        String apellido = JOptionPane.showInputDialog("Apellido:");
        String rut = JOptionPane.showInputDialog("RUT:");
        String calle = JOptionPane.showInputDialog("Calle:");
        String ciudad = JOptionPane.showInputDialog("Ciudad:");
        String region = JOptionPane.showInputDialog("Región:");
        String especialidad = JOptionPane.showInputDialog("Especialidad:");
        String idioma = JOptionPane.showInputDialog("Idioma:");
        String mesesStr = JOptionPane.showInputDialog("Meses de experiencia:");

        try {
            int meses = Integer.parseInt(mesesStr);
            Direccion dir = new Direccion(calle, ciudad, region);
            Guia guia = new Guia(nombre, apellido, rut, dir, especialidad, idioma, meses);
            gestor.agregar(guia);
            JOptionPane.showMessageDialog(null, "Guía agregado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: los meses deben ser un número entero.");
        }
    }

    private void agregarVehiculo() {
        String patente = JOptionPane.showInputDialog("Patente:");
        String marca = JOptionPane.showInputDialog("Marca:");
        String tipo = JOptionPane.showInputDialog("Tipo (ej: Minibús, Furgón):");
        String capacidadStr = JOptionPane.showInputDialog("Capacidad de pasajeros:");

        try {
            int capacidad = Integer.parseInt(capacidadStr);
            Vehiculo vehiculo = new Vehiculo(patente, marca, tipo, capacidad);
            gestor.agregar(vehiculo);
            JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: la capacidad debe ser un número entero.");
        }
    }

    private void agregarColaborador() {
        String nombre = JOptionPane.showInputDialog("Nombre del colaborador:");
        String apellido = JOptionPane.showInputDialog("Apellido:");
        String rut = JOptionPane.showInputDialog("RUT:");
        String calle = JOptionPane.showInputDialog("Calle:");
        String ciudad = JOptionPane.showInputDialog("Ciudad:");
        String region = JOptionPane.showInputDialog("Región:");
        String empresa = JOptionPane.showInputDialog("Empresa:");
        String servicio = JOptionPane.showInputDialog("Servicio que presta:");

        Direccion dir = new Direccion(calle, ciudad, region);
        ColaboradorExterno colaborador = new ColaboradorExterno(
                nombre, apellido, rut, dir, empresa, servicio
        );
        gestor.agregar(colaborador);
        JOptionPane.showMessageDialog(null, "Colaborador agregado correctamente.");
    }

    private void mostrarTodos() {
        if (gestor.getEntidades().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay entidades registradas.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (var r : gestor.getEntidades()) {
            sb.append(r.toString()).append("\n------------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Todas las entidades", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarPorTipo() {
        if (gestor.getEntidades().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay entidades registradas.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (var r : gestor.getEntidades()) {
            if (r instanceof Guia g) {
                sb.append("[GUÍA] ").append(g.getNombre()).append(" ").append(g.getApellido()).append("\n");
            } else if (r instanceof ColaboradorExterno c) {
                sb.append("[COLABORADOR] ").append(c.getNombre()).append(" ").append(c.getApellido()).append("\n");
            } else if (r instanceof Vehiculo v) {
                sb.append("[VEHÍCULO] ").append(v.getMarca()).append(" - ").append(v.getPatente()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Entidades por tipo", JOptionPane.INFORMATION_MESSAGE);
    }
}