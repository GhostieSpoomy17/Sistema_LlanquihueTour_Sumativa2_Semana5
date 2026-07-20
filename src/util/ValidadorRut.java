package util;

// Traté de implementar una verificación para validar RUTs existentes basándome en el
// algoritmo real que usa Chile, pero terminé complicándome. Igualmente dejo esta
// clase por aquí existiendo para mostrar que lo intenté

// Esta clase no afecta al código normal

public class ValidadorRut {

    public static boolean validar(String rut) {
        if (rut == null || rut.trim().isEmpty()) {
            return false;
        }

        // Eliminar puntos, espacios y convertir a mayúsculas
        String rutLimpio = rut.replace(".", "")
                .replace(" ", "")
                .toUpperCase()
                .trim();

        // Verificar que tenga guión
        if (!rutLimpio.contains("-")) {
            return false;
        }

        // Separar cuerpo y dígito verificador
        String[] partes = rutLimpio.split("-");
        if (partes.length != 2) {
            return false;
        }

        String cuerpo = partes[0];
        String dvIngresado = partes[1];

        if (dvIngresado.isEmpty() || cuerpo.isEmpty()) {
            return false;
        }

        // Verificar que el cuerpo sea numérico
        try {
            Long.parseLong(cuerpo);
        } catch (NumberFormatException e) {
            return false;
        }

        // Calcular dígito verificador
        String dvCalculado = calcularDv(cuerpo);

        return dvIngresado.equals(dvCalculado);
    }

    private static String calcularDv(String cuerpo) {
        int suma = 0;
        int[] serie = {2, 3, 4, 5, 6, 7};
        int indice = 0;

        for (int i = cuerpo.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(cuerpo.charAt(i)) * serie[indice % 6];
            indice++;
        }

        int resto = 11 - (suma % 11);

        if (resto == 11) return "0";
        if (resto == 10) return "K";
        return String.valueOf(resto);
    }
}