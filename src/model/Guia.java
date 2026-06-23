package model;

public class Guia extends Persona {
    private String especialidad;
    private String idioma;
    private int mesesExperiencia;

    public Guia(String nombre, String apellido, String rut, Direccion direccion,
                String especialidad, String idioma, int mesesExperiencia) {
        super(nombre, apellido, rut, direccion);
        setEspecialidad(especialidad);
        setIdioma(idioma);
        setMesesExperiencia(mesesExperiencia);
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) {
        try {
            if (especialidad == null || especialidad.trim().isEmpty()) {
                throw new IllegalArgumentException("La especialidad no puede estar vacía.");
            }
            this.especialidad = especialidad;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            this.especialidad = "Sin especialidad";
        }
    }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) {
        try {
            if (idioma == null || idioma.trim().isEmpty()) {
                throw new IllegalArgumentException("El idioma no puede estar vacío.");
            }
            this.idioma = idioma;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            this.idioma = "Sin idioma";
        }
    }

    public int getMesesExperiencia() { return mesesExperiencia; }
    public void setMesesExperiencia(int mesesExperiencia) {
        try {
            if (mesesExperiencia < 0) {
                throw new IllegalArgumentException("Los meses de experiencia no pueden ser negativos.");
            }
            this.mesesExperiencia = mesesExperiencia;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            this.mesesExperiencia = 0;
        }
    }

    public String presentarse() {
        return "Hola, soy " + getNombre() + " " + getApellido() +
                ", guía especializado/a en " + especialidad +
                ". Hablo " + idioma + " y tengo " + mesesExperiencia + " meses de experiencia.";
    }

    public boolean esExperimentado() {
        return mesesExperiencia >= 12;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEspecialidad: " + especialidad +
                "\nIdioma: " + idioma +
                "\nMeses de experiencia: " + mesesExperiencia;
    }
}
