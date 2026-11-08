package model;

/**
 * Representa la dirección física de una persona vinculada a Llanquihue Tour.
 * Se utiliza como clase compuesta dentro de {@link Persona}.
 */
public class Direccion {
    private String calle;
    private String numero;
    private String ciudad;
    private String region;

    /**
     * Crea una dirección completa.
     *
     * @param calle  nombre de la calle
     * @param numero número de la propiedad
     * @param ciudad ciudad de residencia
     * @param region región del país
     */
    public Direccion(String calle, String numero, String ciudad, String region) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.region = region;
    }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    @Override
    public String toString() {
        return calle + " " + numero + ", " + ciudad + ", Región de " + region;
    }
}
