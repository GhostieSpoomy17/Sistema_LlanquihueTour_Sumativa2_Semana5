package model;

public class ColaboradorExterno extends Persona implements Registrable {
    private String empresa;
    private String servicio;

    public ColaboradorExterno(String nombre, String apellido, String rut, Direccion direccion,
                              String empresa, String servicio) {
        super(nombre, apellido, rut, direccion);
        setEmpresa(empresa);
        setServicio(servicio);
    }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) {
        if (empresa == null || empresa.trim().isEmpty()) {
            throw new IllegalArgumentException("La empresa no puede estar vacía.");
        }
        this.empresa = empresa;
    }

    public String getServicio() { return servicio; }
    public void setServicio(String servicio) {
        if (servicio == null || servicio.trim().isEmpty()) {
            throw new IllegalArgumentException("El servicio no puede estar vacío.");
        }
        this.servicio = servicio;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("=== COLABORADOR EXTERNO ===");
        System.out.println("Nombre: " + getNombre() + " " + getApellido());
        System.out.println("RUT: " + getRut());
        System.out.println("Empresa: " + empresa);
        System.out.println("Servicio: " + servicio);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEmpresa: " + empresa +
                "\nServicio: " + servicio;
    }
}
