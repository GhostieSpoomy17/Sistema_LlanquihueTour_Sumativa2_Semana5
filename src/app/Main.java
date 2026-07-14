package app;

import data.GestorEntidades;
import model.Direccion;
import model.Guia;
import model.Persona;
import service.GuiaService;
import ui.MenuGUI;
import util.LectorArchivo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Código de Sumativa 1
        // ------------------------------
        Direccion dir1 = new Direccion("C. Manuel Antonio Matta", "Llanquihue", "Los Lagos");
        Direccion dir2 = new Direccion("C. Volcán Casablanca", "Puerto Montt", "Los Lagos");
        Direccion dir3 = new Direccion("C. Los Perales", "Frutillar", "Los Lagos");

        Persona persona1 = new Persona("Juanito", "García", "23.157.214-K", dir1);
        Persona persona2 = new Persona("Anita", "Muñoz", "25.842.475-5", dir2);

        Guia guia1 = new Guia("Carla", "Pérez", "11-446.936-7", dir3,
                "Rutas gastronómicas", "Español", 18);

        System.out.println("\nSUMATIVA 1:");

        System.out.println("\n----- PERSONA 1 -----");
        System.out.println(persona1);

        System.out.println("\n----- PERSONA 2 -----");
        System.out.println(persona2);

        System.out.println("\n----- GUÍA -----");
        System.out.println(guia1);
        // ------------------------------

        // Código de Sumativa 2
        // ------------------------------
        System.out.println("\nSUMATIVA 2:");
        System.out.println("\n===== CARGANDO GUÍAS DESDE ARCHIVO =====");
        ArrayList<Guia> listaGuias = LectorArchivo.leerGuias("guias.txt");

        GuiaService servicio = new GuiaService(listaGuias);

        System.out.println("\n----- LISTADO COMPLETO DE GUÍAS -----");
        servicio.mostrarTodos();

        System.out.println("\n----- BÚSQUEDA POR RUT: 14.252.734-5 -----");
        Guia encontrado = servicio.buscarPorRut("14.252.734-5");
        if (encontrado != null) {
            System.out.println("Guía encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("No se encontró un guía con ese RUT.");
        }

        System.out.println("\n----- BÚSQUEDA POR ESPECIALIDAD: Excursiones culturales -----");
        ArrayList<Guia> porEspecialidad = servicio.buscarPorEspecialidad("Excursiones culturales");
        for (Guia g : porEspecialidad) {
            System.out.println(g);
            System.out.println("------------------------");
        }

        System.out.println("\n----- GUÍAS CON 12 MESES O MÁS DE EXPERIENCIA -----");
        ArrayList<Guia> experimentados = servicio.buscarExperimentados();
        for (Guia g : experimentados) {
            System.out.println(g.presentarse());
        }
        // ------------------------------

        // Código de Sumativa 3
        // ------------------------------
        System.out.println("\nSUMATIVA 3:");
        System.out.println("Iniciando interfaz gráfica...");
        GestorEntidades gestor = new GestorEntidades();
        MenuGUI menu = new MenuGUI(gestor);
        menu.iniciar();
        // ------------------------------
    }
}
