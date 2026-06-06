package model;


public class Guia extends Persona {
    private String especialidad;
    private String idioma;
    private int mesesExperiencia;

    public Guia(String nombre, String apellido, String rut, Direccion direccion,
                String especialidad, String idioma, int mesesExperiencia) {
        super(nombre, apellido, rut, direccion);
        this.especialidad = especialidad;
        this.idioma = idioma;
        this.mesesExperiencia = mesesExperiencia;
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public int getMesesExperiencia() { return mesesExperiencia; }
    public void setMesesExperiencia(int mesesExperiencia) { this.mesesExperiencia = mesesExperiencia; }

    @Override
    public String toString() {
        return super.toString() +
                "\nEspecialidad: " + especialidad +
                "\nIdioma: " + idioma +
                "\nMeses de experiencia: " + mesesExperiencia;
    }
}
