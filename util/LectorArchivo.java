package util;

import model.Direccion;
import model.Guia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorArchivo {

    public static ArrayList<Guia> leerGuias(String rutaArchivo) {
        ArrayList<Guia> guias = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    String[] datos = linea.split(";");

                    String nombre = datos[0];
                    String apellido = datos[1];
                    String rut = datos[2];
                    String calle = datos[3];
                    String ciudad = datos[4];
                    String region = datos[5];
                    String especialidad = datos[6];
                    String idioma = datos[7];
                    int mesesExperiencia = Integer.parseInt(datos[8]);

                    Direccion direccion = new Direccion(calle, ciudad, region);
                    Guia guia = new Guia(nombre, apellido, rut, direccion,
                            especialidad, idioma, mesesExperiencia);

                    guias.add(guia);

                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Error al procesar línea: \"" + linea + "\" - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return guias;
    }
}