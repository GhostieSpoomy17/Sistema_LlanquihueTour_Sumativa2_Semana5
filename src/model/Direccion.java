package model;

public class Direccion {
    private String calle;
    private String ciudad;
    private String region;

    public Direccion(String calle, String ciudad, String region) {
        setCalle(calle);
        setCiudad(ciudad);
        setRegion(region);
    }

    public String getCalle() { return calle; }
    public void setCalle(String calle) {
        if (calle == null || calle.trim().isEmpty()) {
            throw new IllegalArgumentException("La calle no puede estar vacía.");
        }
        this.calle = calle;
    }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) {
        if (ciudad == null || ciudad.trim().isEmpty()) {
            throw new IllegalArgumentException("La ciudad no puede estar vacía.");
        }
        this.ciudad = ciudad;
    }

    public String getRegion() { return region; }
    public void setRegion(String region) {
        if (region == null || region.trim().isEmpty()) {
            throw new IllegalArgumentException("La región no puede estar vacía.");
        }
        this.region = region;
    }

    @Override
    public String toString() {
        return calle + ", " + ciudad + ", " + region;
    }
}
