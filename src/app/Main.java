package app;


import model.Direccion;
import model.Guia;
import model.Persona;

public class Main {
    public static void main(String[] args) {

        Direccion dir1 = new Direccion("C. Manuel Antonio Matta", "Llanquihue", "Los Lagos");
        Direccion dir2 = new Direccion("C. Volcán Casablanca", "Puerto Montt", "Los Lagos");
        Direccion dir3 = new Direccion("C. Los Perales", "Frutillar", "Los Lagos");

        Persona persona1 = new Persona("Juanito", "García", "23.157.214-K", dir1);
        Persona persona2 = new Persona("Anita", "Muñoz", "25.842.475-5", dir2);

        Guia guia1 = new Guia("Carla", "Pérez", "11-446.936-7", dir3,
                "Rutas gastronómicas", "Español", 18);

        System.out.println("----- PERSONA 1 -----");
        System.out.println(persona1);

        System.out.println("\n----- PERSONA 2 -----");
        System.out.println(persona2);

        System.out.println("\n----- GUÍA -----");
        System.out.println(guia1);
    }
}
