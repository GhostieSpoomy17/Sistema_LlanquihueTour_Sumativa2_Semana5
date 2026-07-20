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
                case 3 -> JOptionPane.showMessageDialog(null,
                        gestor.construirResumenTodos(),
                        "Todas las entidades",
                        JOptionPane.INFORMATION_MESSAGE);
                case 4 -> JOptionPane.showMessageDialog(null,
                        gestor.construirResumenPorTipo(),
                        "Entidades por tipo",
                        JOptionPane.INFORMATION_MESSAGE);
                case 5, -1 -> continuar = false;
            }
        }

        JOptionPane.showMessageDialog(null, "Sistema cerrado. ¡Hasta pronto!");
    }

    private String pedirDato(String mensaje) {
        String dato = JOptionPane.showInputDialog(mensaje);
        if (dato == null) {
            throw new IllegalArgumentException("Operación cancelada por el usuario.");
        }
        if (dato.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo no puede estar vacío.");
        }
        return dato.trim();
    }

    private void agregarGuia() {
        try {
            String nombre = pedirDato("Nombre del guía:");
            String apellido = pedirDato("Apellido:");
            String rut = pedirDato("RUT:");
            String calle = pedirDato("Calle:");
            String ciudad = pedirDato("Ciudad:");
            String region = pedirDato("Región:");
            String especialidad = pedirDato("Especialidad:");
            String idioma = pedirDato("Idioma:");
            String mesesStr = pedirDato("Meses de experiencia:");

            int meses = Integer.parseInt(mesesStr);
            Direccion dir = new Direccion(calle, ciudad, region);
            Guia guia = new Guia(nombre, apellido, rut, dir, especialidad, idioma, meses);
            gestor.agregar(guia);
            JOptionPane.showMessageDialog(null, "Guía agregado correctamente.");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarVehiculo() {
        try {
            String patente = pedirDato("Patente:");
            String marca = pedirDato("Marca:");
            String tipo = pedirDato("Tipo (ej: Minibús, Furgón):");
            String capacidadStr = pedirDato("Capacidad de pasajeros:");

            int capacidad = Integer.parseInt(capacidadStr);
            Vehiculo vehiculo = new Vehiculo(patente, marca, tipo, capacidad);
            gestor.agregar(vehiculo);
            JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente.");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarColaborador() {
        try {
            String nombre = pedirDato("Nombre del colaborador:");
            String apellido = pedirDato("Apellido:");
            String rut = pedirDato("RUT:");
            String calle = pedirDato("Calle:");
            String ciudad = pedirDato("Ciudad:");
            String region = pedirDato("Región:");
            String empresa = pedirDato("Empresa:");
            String servicio = pedirDato("Servicio que presta:");

            Direccion dir = new Direccion(calle, ciudad, region);
            ColaboradorExterno colaborador = new ColaboradorExterno(
                    nombre, apellido, rut, dir, empresa, servicio
            );
            gestor.agregar(colaborador);
            JOptionPane.showMessageDialog(null, "Colaborador agregado correctamente.");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
        }
    }
}
